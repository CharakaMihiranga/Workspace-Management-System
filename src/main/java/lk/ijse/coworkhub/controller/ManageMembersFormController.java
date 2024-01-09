package lk.ijse.coworkhub.controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import lk.ijse.coworkhub.bo.BOFactory;
import lk.ijse.coworkhub.bo.MemberBO;
import lk.ijse.coworkhub.dao.SQLUtil;
import lk.ijse.coworkhub.dto.MemberDTO;
import lk.ijse.coworkhub.dto.MessageDTO;
import lk.ijse.coworkhub.entity.Member;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class ManageMembersFormController {


    @FXML
    private ImageView btnUpdate;
    @FXML
    private Button btnRegister;
    @FXML
    private AnchorPane MemberPane;
    @FXML
    private AnchorPane paneMember;
    @FXML
    private ImageView imgMemberPhoto;
    @FXML
    private DatePicker dob;

    @FXML
    private Label labelAge;

    @FXML
    private Label labelFullName;

    @FXML
    private Label labelMemberId;

    @FXML
    private Label labelPoints;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmergencyNo;

    @FXML
    private TextField txtFname;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtMoNumber;

    @FXML
    private TextField txtProfession;

    @FXML
    private ImageView addMemberIcon;

    private FileChooser fileChooser = new FileChooser();
    private File file;
    private Image image;
    private ImageView icon = new ImageView();

    boolean addMemberClicked = false;

    DropShadow glow = new DropShadow();

    MemberBO memberBO =
            (MemberBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEMBER);

    public void initialize(){
        generateNextID();
    }

    private void generateNextID() {

    }

    @FXML
    private void BrowseMemberPicture(ActionEvent actionEvent) throws IOException {

       if (addMemberClicked) {
           fileChooser.setTitle("Choose Image File");
           file = fileChooser.showOpenDialog(null);

           try {
               if (isImageFile(file)) {
                   String path = file.getAbsolutePath();
                   image = new Image(path);
                   imgMemberPhoto.setImage(image);
               } else {
                   new Alert(Alert.AlertType.WARNING, "Invalid file type,Please choose a valid image file").showAndWait();
               }
           } catch (Exception e) {
               new Alert(Alert.AlertType.ERROR, "Unable to Select the Image! + ( " + e + ")").showAndWait();
           }
       }
    }

    private boolean isImageFile(File file) {
        if (file != null) {
            String fileName = file.getName();
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

            return extension.equals("jpg") || extension.equals("jpeg") ||
                    extension.equals("png") || extension.equals("gif") ||
                    extension.equals("bmp") || extension.equals("tiff");
        }
        return false;
    }



    @FXML
    private void AddMemberOnAction(MouseEvent mouseEvent) {
        txtSetEditable(true);
        addMemberClicked = true;
    }

    private void txtSetEditable(boolean action) {

        txtFname.setEditable(action);
        txtLName.setEditable(action);
        txtAdress.setEditable(action);
        txtEmergencyNo.setEditable(action);
        txtEmail.setEditable(action);
        txtProfession.setEditable(action);
        txtMoNumber.setEditable(action);
        dob.setEditable(action);

    }

    @FXML
    private void mouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();


            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    @FXML
    private void mouseExistAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            if (event.getSource() instanceof ImageView) {
                ImageView icon = (ImageView) event.getSource();
                ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
                scaleT.setToX(1);
                scaleT.setToY(1);
                scaleT.play();

                icon.setEffect(null);
            }
        }
    }

    @FXML
    private void registerOnAction(ActionEvent actionEvent) {
        String id = labelMemberId.getText();
        String fName = txtFname.getText();
        String lName = txtLName.getText();
        String email = txtEmail.getText();
        String address = txtAdress.getText();
        Date birthDay = Date.valueOf(dob.getValue());
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDay.toLocalDate(), now);
        int age = period.getYears();
        String profession = txtProfession.getText();
        double loyalty = 50.00;
        String tel = txtMoNumber.getText();
        String emergencyTel = txtEmergencyNo.getText();
        String memberPicPath = image.getUrl();

        try {

            boolean validated = true;

            if(validated){

                boolean isSaved = memberBO.saveMember(new MemberDTO(id,fName,lName,email,address,birthDay,age,profession,loyalty,tel,emergencyTel,memberPicPath));
                System.out.println(isSaved);
                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION,"Member Saved! ");
                    clearTheFields();
                    txtSetEditable(false);
                }
            }
        } catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Failed to register the member! "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearTheFields() {
        txtFname.clear();
        txtLName.clear();
        txtAdress.clear();
        txtEmergencyNo.clear();
        txtEmail.clear();
        txtProfession.clear();
        txtMoNumber.clear();
        dob.setValue(LocalDate.now());
    }


    @FXML
    private void memberSearchOnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void deleteMemberOnAction(MouseEvent mouseEvent) {
    }

    @FXML
    private void updateMemberOnAction(MouseEvent mouseEvent) {
    }
}

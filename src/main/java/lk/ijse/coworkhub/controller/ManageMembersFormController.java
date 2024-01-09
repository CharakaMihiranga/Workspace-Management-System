package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ManageMembersFormController {


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

    public void initialize(){

    }

    @FXML
    private void BrowseMemberPicture(ActionEvent actionEvent) throws IOException {

       if (addMemberClicked) {
           fileChooser.setTitle("Choose Image File");
           file = fileChooser.showOpenDialog(null);

           try {
               if (isImageFile(file)) {
                   String path = file.getAbsolutePath();
                   image = new Image("file:" + path);
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
        txtSetEditable();
        addMemberClicked = true;
    }

    private void txtSetEditable() {
        txtFname.setEditable(true);
        txtLName.setEditable(true);
        txtAdress.setEditable(true);
        txtEmergencyNo.setEditable(true);
        txtEmail.setEditable(true);
        txtProfession.setEditable(true);
        txtMoNumber.setEditable(true);
        dob.setEditable(true);
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

    }

    @FXML
    private void memberSearchOnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void deleteMemberOnAction(MouseEvent mouseEvent) {
    }
}

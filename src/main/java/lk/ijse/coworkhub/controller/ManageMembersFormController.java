package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    private FileChooser fileChooser = new FileChooser();
    private File file;
    private Image image;

    @FXML
    private void BrowseMemberPicture(ActionEvent actionEvent) throws IOException {

        fileChooser.setTitle("Choose Image File");
        file = fileChooser.showOpenDialog(null);

       try{
           if (isImageFile(file)) {
               String path = file.getAbsolutePath();
               image = new Image("file:" + path);
               imgMemberPhoto.setImage(image);
           } else {
               new Alert(Alert.AlertType.WARNING,"Invalid file type,Please choose a valid image file").showAndWait();
           }
       }catch (Exception e){
           new Alert(Alert.AlertType.ERROR, "Unable to Select the Image! + ( "+ e + ")").showAndWait();
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
}

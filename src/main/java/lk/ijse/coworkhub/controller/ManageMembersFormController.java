package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private JFileChooser fileChooser = new JFileChooser();
    private File file;
    private Image image;

    @FXML
    private void BrowseMemberPicture(ActionEvent actionEvent) throws IOException {

        fileChooser.showOpenDialog(null);
         file = fileChooser.getSelectedFile();
        String path = file.getAbsolutePath();
         image = new Image(path);

        imgMemberPhoto.setImage(image);


    }
}

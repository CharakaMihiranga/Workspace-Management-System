package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private AnchorPane root;

    public void initialize(){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void navigateToDashboard(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/CashierPanel/CashierPanel.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();

    }

}

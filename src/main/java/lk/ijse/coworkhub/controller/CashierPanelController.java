package lk.ijse.coworkhub.controller;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class CashierPanelController {

    public StackPane stack;

    @FXML
    private AnchorPane cashierPanel;

    @FXML
    private ImageView homeIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private ImageView memberIcon;

    @FXML
    private ImageView reservationIcon;

    @FXML
    private ImageView sendMailIcon;

    private Image panelIcon = null;


    public void initialize(){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), cashierPanel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "homeIcon":
                    panelIcon = new Image("/assets/MainFormIcons/GrayIcons/homeGray.png");
                    homeIcon.setImage(panelIcon);
                    break;
                case "logoutIcon":
                    panelIcon = new Image("/assets/MainFormIcons/GrayIcons/icons8-log-out-64.png");
                    logoutIcon.setImage(panelIcon);
                    break;
                case "memberIcon":
                    panelIcon = new Image("/assets/MainFormIcons/GrayIcons/icons8-member-64.png");
                    memberIcon.setImage(panelIcon);
                    break;

                case "sendMailIcon":
                    panelIcon = new Image("/assets/MainFormIcons/GrayIcons/icons8-sent-100.png");
                    sendMailIcon.setImage(panelIcon);
                    break;

                case "reservationIcon":
                    panelIcon = new Image("/assets/MainFormIcons/GrayIcons/icons8-booking-64.png");
                    reservationIcon.setImage(panelIcon);
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }
    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();


            switch (icon.getId()) {
                case "homeIcon":
                    panelIcon = new Image("/assets/MainFormIcons/icons8-home-48.png");
                   homeIcon.setImage(panelIcon);
                    break;
                case "logoutIcon":
                    panelIcon = new Image("/assets/MainFormIcons/icons8-log-out-64.png");
                    logoutIcon.setImage(panelIcon);
                    break;
                case "memberIcon":
                    panelIcon = new Image("/assets/MainFormIcons/icons8-member-64.png");
                    memberIcon.setImage(panelIcon);
                    break;

                case "sendMailIcon":
                    panelIcon = new Image("/assets/MainFormIcons/icons8-sent-50.png");
                    sendMailIcon.setImage(panelIcon);
                    break;

                case "reservationIcon":
                    panelIcon = new Image("/assets/MainFormIcons/icons8-booking-64.png");
                    reservationIcon.setImage(panelIcon);
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.GOLD);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }
    @FXML
    private void navigate(MouseEvent event) throws Exception {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "homeIcon":
                    root = FXMLLoader.load(this.getClass().getResource("/view/CashierPanel/Place-Coffee-Form.fxml"));
                    break;

                case "logoutIcon":
                    logout();
                    break;

                case "memberIcon":
                    root = FXMLLoader.load(this.getClass().getResource("/view/CashierPanel/Manage-Members-Form.fxml"));
                    break;

                 case "sendMailIcon":
                    root = FXMLLoader.load(this.getClass().getResource("/view/CashierPanel/Manage-Alerts-Form.fxml"));
                    break;
            }

            if (root != null) {

                Scene scene = memberIcon.getScene();

                root.setTranslateY(-scene.getHeight());
                stack.getChildren().add(root);

                Timeline timeline = new Timeline();
                KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

// Ensure layout is updated after the animation
                Platform.runLater(() -> {
                    stack.requestLayout();
                });
                timeline.play();

            }
        }
    }

    private void logout() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Login-Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) cashierPanel.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    private void navigateToReservationForm(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/CashierPanel/Manage-Reservations-Form.fxml"));

        Scene scene = reservationIcon.getScene();

        root.setTranslateY(-scene.getHeight());
        stack.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

// Ensure layout is updated after the animation
        Platform.runLater(() -> {
            stack.requestLayout();
        });
        timeline.play();
    }
}

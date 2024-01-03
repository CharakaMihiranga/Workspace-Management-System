package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class CashierPanelController {

    @FXML
    private AnchorPane root;
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

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }
    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "homeIcon":
               //     root = FXMLLoader.load(this.getClass().getResource("/com/example/layeredarchitecture/manage-customers-form.fxml"));
                    break;
                case "logoutIcon":
                //    root = FXMLLoader.load(this.getClass().getResource("/com/example/layeredarchitecture/manage-items-form.fxml"));
                    break;
                case "memberIcon":
               //     root = FXMLLoader.load(this.getClass().getResource("/com/example/layeredarchitecture/place-order-form.fxml"));
                    break;
                case "reservationIcon":
                 //   root = FXMLLoader.load(this.getClass().getResource("/com/example/layeredarchitecture/Search-Orders.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }
}

package lk.ijse.coworkhub.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CashierPanelController {

    @FXML
    private AnchorPane cashierPanel;

    public void initialize(){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), cashierPanel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}

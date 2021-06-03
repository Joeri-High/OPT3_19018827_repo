package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import sample.ViewNavigator;

public class StartScreenController {

    @FXML
    public void loginButtonPressed()
    {
        ViewNavigator.showView(ViewNavigator.loginScreen);
    }

    @FXML
    public void registerButtonPressed()
    {
        ViewNavigator.showView(ViewNavigator.startScreen);
    }

    @FXML
    public void employeeLoginButtonPressed()
    {

    }
}

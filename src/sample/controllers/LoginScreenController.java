package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.ViewNavigator;


public class LoginScreenController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label failMessage;

    public LoginScreenController()
    {

    }

    @FXML
    public void backButton()
    {
        ViewNavigator.showView(ViewNavigator.startScreen);
    }

    @FXML
    public void login()
    {
        ViewNavigator.showView(ViewNavigator.loginScreen);
    }

}

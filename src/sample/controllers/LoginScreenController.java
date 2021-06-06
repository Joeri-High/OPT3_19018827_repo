package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.ViewNavigator;
import sample.db.db_helper;


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
//        if (db_helper.verify)
        ViewNavigator.showView(ViewNavigator.loginScreen);
    }

}

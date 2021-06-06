package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.db.db_helper;
import sample.ViewNavigator;
import sample.models.Guest;
import sample.models.Person;

import java.sql.ResultSet;

public class RegisterScreenController {

    db_helper db_helper = null;

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField emailAdresField;

    @FXML
    PasswordField passWordField;

    @FXML
    TextField ageField;

    @FXML
    Label failLabel;


    public RegisterScreenController()
    {

    }

    @FXML
    public void backButton()
    {
        ViewNavigator.showView(ViewNavigator.startScreen);
    }

    @FXML
    public void registerButton()
    {
        try {
            int ageField = Integer.parseInt(this.ageField.getText());
            Person person = new Guest(firstNameField.getText(), lastNameField.getText(), emailAdresField.getText(), passWordField.getText(), ageField);
            System.out.println("Guest with first name " + firstNameField.getText() + " is registrating...");
            if (db_helper.registerPerson(person))
            {
                ViewNavigator.showView(ViewNavigator.loginScreen);
                System.out.println("Succesfully registrated!");
            } else {
                failLabel.setText("Something went wrong");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

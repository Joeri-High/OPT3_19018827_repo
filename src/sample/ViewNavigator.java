package sample;

import javafx.fxml.FXMLLoader;
import sample.controllers.*;
import sample.ViewNavigator;

import java.io.IOException;

public class ViewNavigator {

    public static final String mainScreen = "screens/MainScreen.fxml";
    public static final String loginScreen = "screens/LoginScreen.fxml";
    public static final String startScreen = "screens/StartScreen.fxml";
    public static final String registerScreen = "screens/RegisterScreen.fxml";
    public static final String reservationScreen = "screens/ReservationScreen.fxml";

    private static MainScreenController mainScreenController;

    public static void setMainController(MainScreenController mainScreenController)
    {
        ViewNavigator.mainScreenController = mainScreenController;
    }

    public static void showView(String fxml_name)
    {
        try
        {
            mainScreenController.setView(FXMLLoader.load(ViewNavigator.class.getResource(fxml_name)));
            System.out.println("Screen is loading...");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

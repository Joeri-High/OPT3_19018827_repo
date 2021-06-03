package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controllers.*;
import sample.models.Reservation;

import java.io.IOException;

public class Main extends Application {

    FXMLLoader loader = new FXMLLoader();

    public static void main(String[] args)
    {
        launch(args);
        System.out.println();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hotel Reservation System");
        primaryStage.setScene(new Scene(loadMainPane(),800,600));
        primaryStage.show();
    }

    private Pane loadMainPane()
    {
        Pane mainPane = null;
        try
        {
            mainPane = (Pane) loader.load(getClass().getResourceAsStream(ViewNavigator.mainScreen));
        } catch (IOException e) {
            System.out.println("IOException when trying to call the mainScreen!");
            e.printStackTrace();
        }
        MainScreenController mainScreenController = loader.getController();
        ViewNavigator.setMainController(mainScreenController);
        ViewNavigator.showView(ViewNavigator.startScreen);
        return mainPane;
    }
}

package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import sample.ViewNavigator;

public class MainScreenController {

    @FXML
    private StackPane mainScreenStackPane;

    public void setView(Node node)
    {
        mainScreenStackPane.getChildren().setAll(node);
    }
}

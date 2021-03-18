package controller.view;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuViewController {

    @FXML
    private Pane menuPane;

    @FXML
    private Button playButton;

    @FXML
    private Button scoreButton;

    @FXML
    private Button contactsButton;

    @FXML
    private Button exitButton;

    @FXML
    void playGame(ActionEvent event) throws IOException {
    	AnchorPane arenaPane = FXMLLoader.load(getClass().getResource("/arena.fxml"));
    	menuPane.getChildren().setAll(arenaPane);
    }

    @FXML
    void openScore(ActionEvent event) throws IOException {
        Pane scorePane = FXMLLoader.load(getClass().getResource("/scoreBoard.fxml"));
        menuPane.getChildren().setAll(scorePane);
    }

    @FXML
    void openContacts(ActionEvent event) throws IOException {
    	Pane contactsPane = FXMLLoader.load(getClass().getResource("/contacts.fxml"));
    	menuPane.getChildren().setAll(contactsPane);
    }

    @FXML
    void closeGame(ActionEvent event) {
        Platform.exit();
    }


}




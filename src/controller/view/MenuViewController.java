package controller.view;

import java.io.IOException;

import controller.SpaceInvadersControllerImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuViewController {

    @FXML
    private Pane RootPane;

    @FXML
    private Button PlayButton;

    @FXML
    private Button ScoreButton;

    @FXML
    private Button HelpButton;

    @FXML
    private Button ExitButton;

    @FXML
    void playGame(ActionEvent event) {
    	final Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   	    new SpaceInvadersControllerImpl(secondaryStage);
    }

    @FXML
    void openScore(ActionEvent event) throws IOException {
        Pane scorePane = FXMLLoader.load(getClass().getResource("/scoreBoard.fxml"));
        RootPane.getChildren().setAll(scorePane);
    }

    @FXML
    void openContacts(ActionEvent event) throws IOException {
    	Pane contactsPane = FXMLLoader.load(getClass().getResource("/contacts.fxml"));
        RootPane.getChildren().setAll(contactsPane);
    }

    @FXML
    void closeGame(ActionEvent event) {
        Platform.exit();
    }


}




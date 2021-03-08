package controller.view;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

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
    	System.out.println("GIOCA");
    }
    
    @FXML
    void openScore(ActionEvent event) throws IOException {
    	Pane scorePane = FXMLLoader.load(getClass().getResource("/scoreBoard.fxml"));
    	RootPane.getChildren().setAll(scorePane);
    }
    
    @FXML
    void openHelp(ActionEvent event) {
    	System.out.println("AIUTO");
    }
    
    @FXML
    void closeGame(ActionEvent event) {
    	Platform.exit();
    }


}

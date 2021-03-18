package controller.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ScoreBoardViewController {
	
    @FXML
    private Pane scorePane;

    @FXML
    private Button backButton;

    @FXML
    void back(ActionEvent event) throws IOException {
    	Pane MenuPane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
    	scorePane.getChildren().setAll(MenuPane);

    }

}

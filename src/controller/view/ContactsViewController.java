package controller.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ContactsViewController {
	
	 @FXML
	 private Pane RootPane;

	 @FXML
	 private Button BackButtonC;
	  
	@FXML
	void backC(ActionEvent event) throws IOException {
		Pane menuPane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        RootPane.getChildren().setAll(menuPane);

    }

}

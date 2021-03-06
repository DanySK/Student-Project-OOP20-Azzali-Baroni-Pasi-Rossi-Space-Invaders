package controller.view;


import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuViewController {

	public void clickPlay(final ActionEvent event) {
        final Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //new (primaryStage);
	}
/*@FXML
	public void clickScore(final ActionEvent event) throws IOException{
	
	final Parent scoreBoard = FXMLLoader.load(ClassLoader.getSystemResource("layouts/scoreboard.fxml"));
	final Scene scoreBoardScene = new Scene(scoreBoard);
	final Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	
	window.setScene(scoreBoardScene);
	window.show();
}*/

}

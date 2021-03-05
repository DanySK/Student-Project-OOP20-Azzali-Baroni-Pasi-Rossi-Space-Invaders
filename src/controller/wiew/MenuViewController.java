package controller.wiew;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MenuViewController {
	
	public void clickPlay(final ActionEvent event) {
        final Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //new (primaryStage);
	}

}

package application;
	
import javax.swing.SwingUtilities;

import controller.Controller;
import controller.ControllerImpl;
import controller.KeyPolling;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.View;
import view.ViewImpl;



public class Main {
	
    /*private static final int SCENE_WIDTH = 854;
    private static final int SCENE_HEIGHT = 480;
    private static final String MENU = "/menu.fxml";
    private static final String TITLE = "Space Invaders";
    private static final String ICON ="/icon.png";
    
	@Override
	public void start(final Stage primaryStage) throws Exception{
		final Parent root = FXMLLoader.load(getClass().getResource(MENU));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        //scene.getStylesheets().add("menuStyle.css");
        root.getStylesheets().add(getClass().getResource("/menuStyle.css").toExternalForm());
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(ICON));
        // Stage configuration
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        KeyPolling.getInstance().pollScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}*/
	
	public void main(final String[] args) {
		//ImageLoader.getLoader().findImages();
		//FontLoader.loadFont();
		final Controller controller = new ControllerImpl();
		final View view = new ViewImpl();
		view.attach(controller);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				view.start();
				
			}
			
		});
		
	}

	
}

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	
    private static final int SCENE_WIDTH = 1270;
    private static final int SCENE_HEIGHT = 700;
    private static final String MENU = "/menu.fxml";
    private static final String TITLE = "Space Invaders";
    
	@Override
	public void start(final Stage primaryStage) throws Exception{
		final Parent root = FXMLLoader.load(getClass().getResource(MENU));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Stage configuration
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.SpaceInvadersButton;
import model.SpaceInvadersSubscene;

public class ViewManager {
	
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_BUTTONS_START_Y = 150;
	
	private SpaceInvadersSubscene credistsSubScene;
	
	List<SpaceInvadersButton> menuButtons;
	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createSubScenes();
		createButtons();
		crateBackground();
		createLogo();
	}
	
	private void createSubScenes() {
		credistsSubScene = new SpaceInvadersSubscene();
		mainPane.getChildren().add(credistsSubScene);
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void addMenuButton(SpaceInvadersButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size()* 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
		
	}
	private void createButtons() {
		createStartButton();
		createScoreButton();	
		createHelpButton();
		createCreditsButton();
		createExitButton();
		
		
	}	
	
	private void createStartButton() {
		SpaceInvadersButton startButton = new SpaceInvadersButton("PLAY");
		addMenuButton(startButton);
	}
	private void createScoreButton() {
		SpaceInvadersButton scoreButton = new SpaceInvadersButton("SCORES");
		addMenuButton(scoreButton);
	}
	private void createHelpButton() {
		SpaceInvadersButton helpButton = new SpaceInvadersButton("HELP");
		addMenuButton(helpButton);
	}
	private void createCreditsButton() {
		SpaceInvadersButton creditsButton = new SpaceInvadersButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				credistsSubScene.moveSubscene();
				
			}
			
		});
		
	}
	
	
	private void createExitButton() {
		SpaceInvadersButton exitButton = new SpaceInvadersButton("EXIT");
		addMenuButton(exitButton);
	}
	
	private void crateBackground() {
		Image backgroundImage = new Image("view/resources/black.png",256,256,false,true);
		BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("view/resources/logo.png");
		logo.setLayoutX(350);
		logo.setLayoutY(35);
        
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
				
			}
			
		});


		
		logo.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
				
			}
			
		});
		mainPane.getChildren().add(logo);
	}
}

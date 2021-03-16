package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import controller.SpaceInvadersController;
import controller.SpaceInvadersControllerImpl;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SpaceInvadersViewImpl implements SpaceInvadersView{
	
	private static final String TITLE = "SpaceInvaders";
	private static final double HEIGHT = 480;
	private static final double WIDTH = 854;
	private static final double FONT_SIZE = 18;
	private final Label score = new Label();
	private final SpaceInvadersObserver observer;
	private Stage secondaryStage;
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Pane root;
	
	//URL url = getClass().getClassLoader().getResource("BackgroundMenu.jpg");
	
	
	public SpaceInvadersViewImpl(final Stage secondaryStage, final SpaceInvadersObserver observer) {
		this.secondaryStage = secondaryStage;
		this.observer = observer;
		

	}

	@Override
	public void start() {
	screenSize.setSize(WIDTH,HEIGHT);	
		this.secondaryStage.setTitle(TITLE);
		this.secondaryStage.centerOnScreen();
		//settare sfondo di gioco
		this.setBackgroundGame(screenSize);
		//root.getChildren().add(p);
	}
	
	private void setBackgroundGame(final Dimension screensize) {
		this.root = new Pane();
		final Scene scene = new Scene(this.root,screenSize.getWidth(),screenSize.getHeight());
		final ImageView background = new ImageView(new Image(ClassLoader.getSystemResource("backgroundGame.png").toString()));
		this.root.getChildren().add(background);
		
		this.score.setText(" Score: 0");
		this.score.setFont(new Font("Bauhaus 93",this.root.getHeight() / FONT_SIZE));
		this.score.setTextFill(Paint.valueOf(String.valueOf(Color.WHITE)));
		this.root.getChildren().add(this.score);
		
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		//this.spaceinvadercontroller.startGame();
		this.observer.startGame();
		
		
		secondaryStage.setScene(scene);
		movementListener(scene);
		
	   
	}

	@Override
	public void setScore(final int score) {
	  this.score.setText("Score: "+ score);
		
	}

	@Override
	public void addChildren(Node n) {
		// TODO Auto-generated method stub
		this.root.getChildren().add(n);
		
	}

	@Override
	public void movementListener(Scene scene) {
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case A:
				//player.moveleft();
				this.observer.moveLeft();
				break;
			case D:
				//player.moveRight();
				this.observer.moveRight();
				break;
			case SPACE:
				//Shoot();
				break;
			default:
				break;
			}
		});
		
	}

	@Override
	public double getWidth() {
		return screenSize.getWidth();
	}

	
	
	
	

}

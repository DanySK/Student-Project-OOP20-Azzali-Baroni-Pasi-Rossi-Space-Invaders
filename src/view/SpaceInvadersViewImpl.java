package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SpaceInvadersViewImpl implements SpaceInvadersView{
	
	private static final String TITLE = "SpaceInvaders";
	private static final double HEIGHT=854;
	private static final double WIDTH = 480;
	private static final double FONT_SIZE=18;
	private Stage secondaryStage;
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Pane root;
	
	
	public SpaceInvadersViewImpl(final Stage secondaryStage) {
		this.secondaryStage = secondaryStage;
	}

	@Override
	public void start() {
	screenSize.setSize(WIDTH,HEIGHT);	
		this.secondaryStage.setTitle(TITLE);
		this.secondaryStage.centerOnScreen();
		//settare sfondo di gioco
		this.root = new Pane();
		final Scene scene = new Scene(this.root,screenSize.getWidth(),screenSize.getHeight());
		final ImageView background = new ImageView(new Image(ClassLoader.getSystemResource("BackgroundMenu.jpg").toString()));
		this.root.getChildren().add(background);
		this.start();
	   
	
	}
	

}

package model;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class SpaceInvadersSubscene extends SubScene {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	private final String BACKGROUND_IMAGE = "model/resources/red_panel.png";

	private boolean isHidden;

	public SpaceInvadersSubscene() {
		super(new AnchorPane(), 600, 400);
		prefHeight(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true),
				BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		setLayoutX(1024);
		setLayoutY(180);
		
	}
	public void moveSubscene() {
		TranslateTransition transaction = new TranslateTransition();
		transaction.setDuration(Duration.seconds(0.3));
		transaction.setNode(this);
		if(isHidden) {
		transaction.setToX(-676);
		isHidden = false;
		}else {
			transaction.setToX(0);
			isHidden = true;
		}
		transaction.play();
		
	}

}

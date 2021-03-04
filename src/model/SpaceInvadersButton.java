package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class SpaceInvadersButton extends Button{

	private final String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	private final String BUTTON_STYLE = "-fx-background-color:transparent; -fx-background-image: url('/model/resources/red_button_pressed.png');";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color:transparent; -fx-background-image: url('/model/resources/red_button.png');";
	
	public SpaceInvadersButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_STYLE);
		initializeButtonListeners();
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana,23"));
		}
	}
	
	
	private void setButtonPressed() {
		setStyle(BUTTON_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY()+4);
	}
	
	private void setButtonRelased() {
		setStyle(BUTTON_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY()-4);
	}
	
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressed();
				}
				
			}
			
		});
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonRelased();
				}
				
			}
			
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
				
			}
			
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
				
			}
			
		});
	}
	
	
	
	
}
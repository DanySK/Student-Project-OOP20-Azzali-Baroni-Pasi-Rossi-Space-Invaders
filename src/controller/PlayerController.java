package controller;

import model.Player;
import view.PlayerView;

public interface PlayerController {

	
	void initPlayerView();
	
	void playerMovement(double n);
	
	//boolean collision(Rectangle r);
	
	PlayerView getPlayerView();
	
	Player getPlayerModel();
}

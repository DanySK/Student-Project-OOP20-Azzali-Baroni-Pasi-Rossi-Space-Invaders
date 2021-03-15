package controller;

import model.Entity;
import view.PlayerView;

public interface PlayerController {

	
	void initPlayerView();
	
	void playerMovement(double n);
	
	//boolean collision(Rectangle r);
	
	PlayerView getPlayerView();
	
	Entity getPlayerModel();
	
	double screenCheck(double x);
}

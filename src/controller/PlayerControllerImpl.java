package controller;

import model.Entity;
import model.PlayerImpl;
import view.PlayerView;
import view.PlayerViewImpl;

public class PlayerControllerImpl implements PlayerController{

	public static final int SCREEN_WIDTH = 810;
	
	private double newPosition;
	private final PlayerImpl player;
	private final PlayerView playerView;
	
	public PlayerControllerImpl() {
		
		player = new PlayerImpl();
		playerView = new PlayerViewImpl();
		this.initPlayerView();
	}

	@Override
	public void initPlayerView() {
		playerView.setPosition(player.getPosX(), player.getPosY());
        playerView.setWidthHeight(player.getHeight(), player.getWidth());
        playerView.setImage(player.getImagePath());
		
	}

	@Override
	public void playerMovement(double n) {
		// TODO Auto-generated method stub
		//newPosition = player.getPosX()+n;
		
		player.setPosition(screenCheck(n));
		playerView.updatePosition(screenCheck(n));
	}

	@Override
	public PlayerView getPlayerView() {
		return this.playerView;
	}

	@Override
	public Entity getPlayerModel() {
		return this.player;
	}

	@Override
	public double screenCheck(double x) {
		newPosition = player.getPosX()+x;
		if((newPosition >= 0)&&(newPosition < SCREEN_WIDTH)){
			return (player.getPosX()+x);
		}else
		return player.getPosX();
	}
	
}

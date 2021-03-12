package controller;

import model.Player;
import model.PlayerImpl;
import view.PlayerView;
import view.PlayerViewImpl;

public class PlayerControllerImpl implements PlayerController{

	public static final int SCREEN_HEIGHT = 335;
	
	private final Player player;
	private final PlayerView playerView;
	
	public PlayerControllerImpl() {
		
		player = new PlayerImpl();
		playerView = new PlayerViewImpl();
		this.initPlayerView();
	}

	@Override
	public void initPlayerView() {
		playerView.setPosition(player.getPosX(), player.getPosY());
        playerView.setWidthHeight(player.getHeightBird(), player.getWidthPlayer());
        playerView.setImage(player.getPlayerImagePath());
		
	}

	@Override
	public void playerMovement(double n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlayerView getPlayerView() {
		return this.playerView;
	}

	@Override
	public Player getPlayerModel() {
		return this.player;
	}
}

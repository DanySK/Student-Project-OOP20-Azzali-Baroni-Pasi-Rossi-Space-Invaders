package controller;

import javafx.stage.Stage;
import view.SpaceInvadersObserver;
import view.SpaceInvadersView;
import view.SpaceInvadersViewImpl;

public class SpaceInvadersControllerImpl implements SpaceInvadersController,SpaceInvadersObserver {

	private final SpaceInvadersView view;
	private final PlayerController player;
	private final EnemyController enemy;

	
	public SpaceInvadersControllerImpl(final Stage secondaryStage) {

		enemy = new EnemyControllerImpl();
		player = new PlayerControllerImpl();
		view = new SpaceInvadersViewImpl(secondaryStage, this);
		view.start();
	}

	@Override
	public void startGame() {
		this.view.addChildren(player.getPlayerView().getPlayer());
		this.view.addChildren(enemy.getEnemyView().getEnemy());
	}

	@Override
	public void moveLeft() {
		player.playerMovement(-5);
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		player.playerMovement(+5);
	}
	
	
	
		
	
}

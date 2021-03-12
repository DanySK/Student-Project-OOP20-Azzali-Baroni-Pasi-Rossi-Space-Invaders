package controller;

import javafx.stage.Stage;
import view.SpaceInvadersView;
import view.SpaceInvadersViewImpl;

public class SpaceInvadersControllerImpl implements SpaceInvadersController {

	private final SpaceInvadersView view;
	private final PlayerController player;
	
	public SpaceInvadersControllerImpl(final Stage secondaryStage) {

		player = new PlayerControllerImpl();
		view = new SpaceInvadersViewImpl(secondaryStage);
		view.start();
	}
	
	public final void startGame() {
		this.view.addChildren(player.getPlayerView().getPlayer());
	}
}

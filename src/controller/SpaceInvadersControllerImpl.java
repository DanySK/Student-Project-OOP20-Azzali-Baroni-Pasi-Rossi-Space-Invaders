package controller;

import javafx.stage.Stage;
import view.SpaceInvadersView;
import view.SpaceInvadersViewImpl;

public class SpaceInvadersControllerImpl implements SpaceInvadersController {

	private final SpaceInvadersView view;
	
	public SpaceInvadersControllerImpl(final Stage secondaryStage) {
		view = new SpaceInvadersViewImpl(secondaryStage);
		view.start();
	}
}

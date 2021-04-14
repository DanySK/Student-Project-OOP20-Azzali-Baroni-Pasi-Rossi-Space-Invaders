package controller.view;

import view.GameP;
import view.StateV;

public interface ViewObserver {
	
	void update(GameP panel,StateV state);

}

package controller;

import controller.view.ViewObserver;
import model.GameStatus;
import view.View;

public interface Controller extends ViewObserver{
	
	
	//Setta la view
	void setView(View view);
	
	
	//Controlla lo status del GameLoop
	GameStatus checkGameStatus();

}

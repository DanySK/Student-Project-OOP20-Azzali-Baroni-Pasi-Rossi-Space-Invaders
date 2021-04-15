package controller;

/**
 * 
 * Classe per contare il tempo in modo sincrono con gameLoop
 *
 */

public interface Chronometer {
	
	void tick();
	
	boolean isEnded();
	
	int getTimeLeft();
}

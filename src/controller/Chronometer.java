package controller;

/**
 * Classe per contare il tempo in modo sincrono con gameLoop.
 */

public interface Chronometer {
	
	/**
	 * Tick.
	 */
	void tick();
	
	/**
	 * Checks if is ended.
	 *
	 * @return true, if is ended
	 */
	boolean isEnded();
	
	/**
	 * Gets the time left.
	 *
	 * @return the time left
	 */
	int getTimeLeft();
}

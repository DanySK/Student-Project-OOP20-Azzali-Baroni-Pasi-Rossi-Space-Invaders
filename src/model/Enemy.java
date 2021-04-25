package model;

/**
 * The Interface Enemy.
 */
public interface Enemy {
	
	/**
	 * Tiedup X.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	boolean tiedupX(int n);
	
	/**
	 * Tiedup Y.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	boolean tiedupY(int n);
	
	/**
	 * Delete list.
	 */
	void deleteList();
	
	/**
	 * Adds the number.
	 *
	 * @param list the list
	 * @param n the n
	 */
	void addNumber(boolean list, int n);

}

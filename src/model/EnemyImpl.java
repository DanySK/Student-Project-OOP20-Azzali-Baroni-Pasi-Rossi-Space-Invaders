package model;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class EnemyImpl.
 */
public class EnemyImpl implements Enemy{
	
	/** The list enemy X. */
	private final List<Integer> listEnemyX;
	
	/** The list enemy Y. */
	private final List<Integer> listEnemyY;
	
	/** The hit. */
	private final int hit; 
	
	/**
	 * Instantiates a new enemy impl.
	 *
	 * @param hit the hit
	 */
	public EnemyImpl(final int hit) {
		this.hit = hit;
		listEnemyX = new LinkedList<>();
		listEnemyY = new LinkedList<>();
	}

	/**
	 * Tiedup X.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	@Override
	public boolean tiedupX(final int n) {
		for (final int x : listEnemyX) {
			if (x == n || (x >= n - hit && x <= n + hit)) {
				return true;
			}
		}
		
		return false;		
	}

	/**
	 * Tiedup Y.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	@Override
	public boolean tiedupY(final int n) {
		for (final int x : listEnemyY) {
			if (x == n || (x >= - hit && x <= n + hit)) {}
			return true;
		}
		return false;
	}

	/**
	 * Delete list.
	 */
	@Override
	public void deleteList() {
		listEnemyX.clear();
		listEnemyY.clear();
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * Adds the number.
	 *
	 * @param list the list
	 * @param n the n
	 */
	@Override
	public void addNumber(boolean list, int n) {
		if(list) {
			listEnemyX.add(n);
			}
		else {
			listEnemyY.add(n);
		}
		
		
		// TODO Auto-generated method stub
		
	}
	

	}
	
	



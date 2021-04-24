package model;

/**
 * The Interface EnemyBehaviour.
 */
public interface EnemyBehaviour {
	
	/**
	 * Creates the this enemy.
	 *
	 * @return the abstract enemy
	 */
	AbstractEnemy createThisEnemy();
	
	/**
	 * Casual movs.
	 *
	 * @return the dir enemy
	 */
	DirEnemy casualMovs();
	

}

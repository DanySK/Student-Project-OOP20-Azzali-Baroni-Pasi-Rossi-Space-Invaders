package model;

import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import utility.Pair;

/**
 * The Class AbstractEnemy.
 */
public abstract class AbstractEnemy extends EntityImpl implements EnemyBehaviour {
	
	/** The Constant WIDTH_X. */
	private static final int WIDTH_X = GameImpl.ARENA_WIDTH;
	
	/** The Constant HEIGHT_Y. */
	private static final int HEIGHT_Y = GameImpl.ARENA_HEIGHT;
	
	/** The Constant ENEMY_SPAWN_HEIGHT. */
	private static final int ENEMY_SPAWN_HEIGHT = 115;
	
	/** The model. */
	private final Enemy model;
	
	/** The hit. */
	private final int hit; 
	
	/** The done. */
	private boolean done;

	/**
	 * Instantiates a new abstract enemy.
	 *
	 * @param position the position
	 * @param speedX the speed X
	 * @param speedY the speed Y
	 * @param id the id
	 * @param hit the hit
	 */
	public AbstractEnemy(final Pair<Integer, Integer> position, final int speedX, final int speedY, final ID id, final int hit) {
		super(position, speedX, speedY, id);
		this.hit = hit;
		done = false;
		model = new EnemyImpl(hit);
	}

	/**
	 * Creates the enemy.
	 *
	 * @return the abstract enemy
	 */
	protected AbstractEnemy createEnemy() {
		double number;
		do {
			number = ThreadLocalRandom.current().nextDouble(0, WIDTH_X);
		} while ((number > WIDTH_X / 3 && number < (WIDTH_X * 2) / 3) || model.tiedupX((int) number));
		model.addNumber(true, (int) number);
		this.getPosition().setX((int) number);
		do {
			number = ThreadLocalRandom.current().nextDouble(0, HEIGHT_Y);
		} while ((number > HEIGHT_Y / 4 && number < (HEIGHT_Y * 3) / 4) || model.tiedupY((int) number));
		this.getPosition().setY(ENEMY_SPAWN_HEIGHT);
		done = false;
		return this;
	}

	/**
	 * Delete list.
	 */
	protected void deleteList() {
		if (!done) {
			model.deleteList();
			done = true;
		}
	}

	/**
	 * Sets the hitbox.
	 */
	protected void setHitbox() {
		setHitbox(new Rectangle(this.getPosition().getX() - (hit / 2 ), this.getPosition().getY() - (hit / 2), hit, hit));

	}	

	/**
	 * Enemy shot.
	 *
	 * @param dir the dir
	 * @param game the game
	 * @param id the id
	 */
	protected void enemyShot(final DirEnemy dir, final GameImpl game, final ID id) {
		if (id == ID.BOSS_ENEMY) {
			game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY(), DirEnemy.D_R));
			game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY(), DirEnemy.D_L));
			game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY(), DirEnemy.DOWN));
		} else {
			game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY(), DirEnemy.DOWN));
		}
	}

	/**
	 * Check shotgun.
	 *
	 * @param shotgun the shotgun
	 * @param timeShot the time shot
	 * @return true, if successful
	 */
	protected boolean checkShotgun(final int shotgun, final int timeShot) {
		return shotgun == timeShot ? true : false;
	}

	/**
	 * Move.
	 *
	 * @param dir the dir
	 */
	protected void move(final DirEnemy dir) {
		switch (dir) {
		case DOWN: this.getPosition().setY(this.getPosition().getY() + this.getSpeed().getY());
		break;
		case LEFT: this.getPosition().setX(this.getPosition().getX() - this.getSpeed().getX());
		break;
		case RIGHT: this.getPosition().setX(this.getPosition().getX() + this.getSpeed().getX());
		break;
		default:
			break;
		}
		setHitbox();
	}

	/**
	 * Check position.
	 *
	 * @param dir the dir
	 * @return the dir enemy
	 */
	protected DirEnemy checkPosition(final DirEnemy dir) {
		if (this.getPosition().getX() - hit <= 0) {
			return DirEnemy.RIGHT;
		} else if (this.getPosition().getX() + hit >= GameImpl.ARENA_WIDTH) {
			return DirEnemy.LEFT;
		} 

		setHitbox();
		return dir;

	}
	
	/**
	 * Game over.
	 *
	 * @param enemy the enemy
	 * @return the boolean
	 */
	public Boolean gameOver(AbstractEnemy enemy) {
		if(this.getPosition().getY() >= 900) {
			return true;
		}
		return false;
	}
}


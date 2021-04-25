package model;

import java.awt.Rectangle;
import utility.Pair;

/**
 * The Class ShotEnemyImpl.
 */
public class ShotEnemyImpl extends EntityImpl implements ShotEnemy {
	
	/** The Constant MYID. */
	private static final ID MYID = ID.ENEMY_BULLET;
	
	/** The Constant STDSPD. */
	private static final int STDSPD = 3;
	
	/** The Constant HIT. */
	private static final int HIT = GameImpl.ARENA_HEIGHT / 25;
	
	/** The spd. */
	private final Pair<Integer, Integer> spd;
	
	/** The dir. */
	private DirEnemy dir;
	
	/**
	 * Instantiates a new shot enemy impl.
	 *
	 * @param enemyX the enemy X
	 * @param enemyY the enemy Y
	 * @param dir the dir
	 */
	public ShotEnemyImpl(final Integer enemyX, final Integer enemyY, final DirEnemy dir) {
		super(new Pair<Integer, Integer>(enemyX, enemyY), 0, 0, MYID);
		this.dir = dir;
		this.spd = new Pair<Integer, Integer>(0, 0);
		whichSpeed();
		setSpeed(spd.getX(), spd.getY());
		setHitbox(new Rectangle(this.getPosition().getX() - (HIT / 2), this.getPosition().getY() - (HIT / 2), HIT, HIT));
	}
	
	/**
	 * Which speed.
	 */
	private void whichSpeed() {
		switch (dir) {
		case DOWN: spd.setX(0);
		spd.setY(+STDSPD);
		break;
		case D_R: spd.setX(STDSPD);
		spd.setY(+STDSPD);
		break;
		case D_L: spd.setX(-STDSPD);
		spd.setY(+STDSPD);
		break;
		default:
			break;
		}
	}
	
	/**
	 * Update.
	 */
	@Override
	public void update() {
		whichSpeed();
		setSpeed(spd.getX(), spd.getY());
		this.setPosition(new Pair<Integer,Integer>(this.getPosition().getX() + spd.getX(), this.getPosition().getY() + spd.getY()));
		setHitbox(new Rectangle(this.getPosition().getX() - (HIT / 2), this.getPosition().getY() - (HIT / 2), HIT, HIT));
		if (this.getPosition().getY() >= GameImpl.ARENA_HEIGHT || this.getPosition().getY() < 0 || this.getPosition().getX() >= GameImpl.ARENA_WIDTH || this.getPosition().getX() < 0) {
			this.setDead();
		}
		
	}
	
	/**
	 * Collide.
	 *
	 * @param entity the entity
	 */
	@Override
	public void collide(final Entity entity) {
		this.setDead();
	}
	
	/**
	 * Sets the dir.
	 *
	 * @param dir the new dir
	 */
	@Override
	public void setDir(final DirEnemy dir){
		this.dir = dir;
		
	}

}

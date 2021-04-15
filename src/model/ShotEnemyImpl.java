package model;

import java.awt.Rectangle;
import model.EntityImpl;
import model.GameImpl;
import model.Entity;
import model.ID;
import utility.Pair;

public class ShotEnemyImpl extends EntityImpl implements ShotEnemy {
	
	private static final ID MYID = ID.SHOOT;
	private static final int STDSPD = 3;
	private static final int HIT = GameImpl.ARENA_HEIGHT / 25;
	private final Pair<Integer, Integer> spd;
	private DirEnemy dir;
	
	public ShotEnemyImpl(final Integer enemyX, final Integer enemyY, final DirEnemy dir) {
		super(new Pair<Integer, Integer>(enemyX, enemyY), 0, 0, MYID);
		this.dir = dir;
		this.spd = new Pair<Integer, Integer>(0, 0);
		whichSpeed();
		setSpeed(spd.getX(), spd.getY());
		setHitbox(new Rectangle(this.getPosition().getX() - (HIT / 2), this.getPosition().getY() - (HIT / 2), HIT, HIT));
	}
	
	private void whichSpeed() {
		switch (dir) {
		case DOWN: spd.setX(0);
		spd.setY(-STDSPD);
		break;
		case D_R: spd.setX(STDSPD);
		spd.setY(-STDSPD);
		break;
		case D_L: spd.setX(-STDSPD);
		spd.setY(-STDSPD);
		break;
		default:
			break;
		}
	}
	
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
	
	@Override
	public void collide(final Entity entity) {
		this.setDead();
	}
	
	@Override
	public void setDir(final DirEnemy dir){
		this.dir = dir;
		
	}

}

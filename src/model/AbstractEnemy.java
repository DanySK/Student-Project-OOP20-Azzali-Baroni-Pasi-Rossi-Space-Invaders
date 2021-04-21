package model;

import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import utility.Pair;

public abstract class AbstractEnemy extends EntityImpl implements EnemyBehaviour {
	private static final int WIDTH_X = GameImpl.ARENA_WIDTH;
	private static final int HEIGHT_Y = GameImpl.ARENA_HEIGHT;
	private final Enemy model;
	private final int spd;
	private final int hit; 
	private boolean done;
	
	public AbstractEnemy(final Pair<Integer, Integer> position, final int speedX, final int speedY, final ID id, final int hit) {
		super(position, speedX, speedY, id);
		this.spd = speedX;
		this.hit = hit;
		done = false;
		model = new EnemyImpl(hit);
	}
	
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
		this.getPosition().setY(200);
		done = false;
		return this;
	}
	
	protected void deleteList() {
		if (!done) {
			model.deleteList();
			done = true;
		}
	}
	
	protected void setHitbox() {
		setHitbox(new Rectangle(this.getPosition().getX() - (hit / 2 ), this.getPosition().getY() - (hit / 2), hit, hit));
		
	}	
	
	protected void enemyShot(final DirEnemy dir, final GameImpl game, final ID id) {
		if (id == ID.BOSS_ENEMY) {
			switch (dir) {
			case DOWN: 
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY() + spd, dir));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() + spd, this.getPosition().getY() + spd, DirEnemy.D_R));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() - spd, this.getPosition().getY() + spd, DirEnemy.D_L));
			break;
			case D_R: 
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() + spd, this.getPosition().getY() + spd, dir));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY() + spd, DirEnemy.DOWN));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() + spd, this.getPosition().getY(), DirEnemy.RIGHT));
			break;
			case D_L: 
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() - spd, this.getPosition().getY() +spd, dir));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY() + spd, DirEnemy.DOWN));
				game.getShot().add(new ShotEnemyImpl(this.getPosition().getX() - spd, this.getPosition().getY(), DirEnemy.LEFT));
			break;
			default:
				break;
			
			}
		} else {
				switch (dir) {
				case DOWN: game.getShot().add(new ShotEnemyImpl(this.getPosition().getX(), this.getPosition().getY()+spd, dir));
				break;
				default:
					break;
				}
				
			}
		}
	
	protected boolean checkShotgun(final int shotgun, final int timeShot) {
		return shotgun == timeShot ? true : false;
	}
	
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
	
	protected DirEnemy checkPosition(final DirEnemy dir) {
		 if (this.getPosition().getX() - hit <= 0) {
	            return DirEnemy.RIGHT;
	        } else if (this.getPosition().getX() + hit >= GameImpl.ARENA_WIDTH) {
	            return DirEnemy.LEFT;
	        } else if (this.getPosition().getY() + hit >= GameImpl.ARENA_HEIGHT) {
	            return DirEnemy.DOWN;
	        }
		setHitbox();
		return dir;

	}
	
	}


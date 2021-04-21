package model;

import model.GameImpl;
import model.Entity;
import model.ID;
import utility.Pair;

import java.util.Random;

import model.EnemyBehaviour;

public class BossEnemy extends AbstractEnemy{
	
	private static final int HIT = GameImpl.ARENA_HEIGHT / 3;
	private static final ID MYID = ID.BOSS_ENEMY;
	private static final int SPD = 1;
	private static final int TIMESHOT = 20;
	private static final int CMOVIM = 10;
	private final GameImpl game;
	private final Random ran;
	private int shotgun;
	private int life;
	private int count;
	private DirEnemy dir;
	
	public BossEnemy(final GameImpl game) {
		super(new Pair<Integer,Integer>(0, 0), SPD, SPD, MYID, HIT);
		this.game = game;
		ran = new Random();
	}
	
	@Override
	public AbstractEnemy createThisEnemy() {
		if(this.isDead()) {
			this.setAlive();
		}
		this.life = game.getLevel();
		createEnemy();
		deleteList();
		setHitbox();
		dir = casualMovs();
		return this;
		
	}
	
	@Override
	public void update() {
		shotgun++;
		if(count == CMOVIM) {
			dir = casualMovs();
			move(dir);
			count = 0;
		} else {
			count++;
			move(dir);
			dir = checkPosition(dir);
			}
		if(checkShotgun(shotgun, TIMESHOT)) {
			enemyShot(dir, game, MYID);
			shotgun = 0;
		}
	}
	
	@Override
	public void collide (final Entity entity) {
		switch (entity.getID()) {
		case BASIC_ENEMY: case ENEMY_BULLET:
			break;
			default:
				life--;
			
		}
		if (life == 0) {
			this.setDead();
		}

	}
	
	@Override
	public DirEnemy casualMovs() {
		if (ran.nextBoolean()) {
			if (ran.nextBoolean()) {
				dir = DirEnemy.RIGHT;
			} else {
				dir = DirEnemy.LEFT;
			}
//			}else if(ran.nextBoolean()) {
//				dir=DirEnemy.DOWN;	
		}
		else {
			dir = DirEnemy.DOWN;
		}
			return dir;
	}
	
}
	


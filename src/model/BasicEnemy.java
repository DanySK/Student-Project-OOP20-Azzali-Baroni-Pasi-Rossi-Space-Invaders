package model;

import java.util.Random;

import model.GameImpl;
import model.ID;
import utility.Pair;
import model.EnemyBehaviour;

public class BasicEnemy extends AbstractEnemy {
	
	private static final int HIT = GameImpl.ARENA_HEIGHT / 12;
	private static final ID MYID = ID.BASIC_ENEMY;
	private static final int SPD = 1;
	private static final int TIMESHOT = 75;
	private static final int CMOVIM = 250;
	private final GameImpl game;
	private final Random ran;
	private int shotgun;
	private int life = 3;
	private int count;
	private boolean done;
	private DirEnemy dir;
	
	public BasicEnemy(final GameImpl game) {
		super(new Pair<Integer, Integer> (0, 0), SPD, SPD, MYID, HIT);
		this.game = game;
		this.done = false;
		ran = new Random();
	}
	
	@Override
	public AbstractEnemy createThisEnemy() {
		createEnemy();
		setHitbox();
		dir = casualMovs();
		return this;
		
	}
	
	@Override
	public DirEnemy casualMovs() {
		if (ran.nextBoolean()) {
			if (ran.nextBoolean()) {
				dir = DirEnemy.RIGHT;
			} else {
				dir = DirEnemy.LEFT;
			}
		}else if(ran.nextBoolean()) {
			dir = DirEnemy.DOWN;
		}else {
			dir = DirEnemy.DOWN;
		}
			return dir;
		
	} 
	
	@Override
	public void update() {
		shotgun++;
		if(!done) {
			deleteList();
			done = true;
		}
		if(count == CMOVIM) {
			dir = casualMovs();
			move(dir);
			count = 0;
		} else {
			count++;
			move(dir);
			dir = checkPosition(dir);
			}
		if (checkShotgun(shotgun, TIMESHOT)) {
			enemyShot(dir, game,MYID);
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
	}
	 

		
	


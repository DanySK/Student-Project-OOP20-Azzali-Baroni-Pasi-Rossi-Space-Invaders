package model;

import model.GameImpl;
import model.Entity;
import model.ID;
import utility.Pair;
import model.EnemyBehaviour;

public class BossEnemy extends AbstractEnemy{
	
	private static final int HIT = GameImpl.ARENA_HEIGHT / 3;
	private static final ID MYID = ID.BOSS_ENEMY;
	private static final int SPD = 1;
	private static final int TIMESHOT = 75;
	private final GameImpl game;
	private int shotgun;
	private int life;
	private DirEnemy dir;
	
	public BossEnemy(final GameImpl game) {
		super(new Pair<Integer,Integer>(0, 0), SPD,SPD, MYID, HIT );
		this.game = game;
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
		return this;
		
	}
	
	@Override
	public void update() {
		shotgun++;
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
		return null;
	}
	
}
	


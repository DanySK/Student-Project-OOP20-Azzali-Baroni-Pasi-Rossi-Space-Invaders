package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import game.InterfaceLevel;
import game.Level;
import game.enemy.Shot;

public class GameImpl implements Game{

   public static final int ARENA_WIDTH = 1600;

   public static final int ARENA_HEIGHT = 900;

   private static final int ENEMY_DEAD = 10;
   private static final int LEVEL_CLEARED = 1;
	
	private GameStatus gameStatus;
	private final PlayerImpl player;
	//private final Optional<List<Enemy>> enemies;
	//private final Optional<List<Obstacles>> obstacles;
	private final List<BulletImpl> bullets;
	//private final List<Effect> effects;
//    private final Optional<List<Shot>> shots;
    //private final List<PlayerPowerUp> playerPowerUps;
    //private Optional<GlobalPowerUp> globalPowerUp;
//    private final InterfaceLevel level;
    private int score;
    private boolean freeze;
    
    public GameImpl() {
    	this.gameStatus = GameStatus.RUNNING;
//    	this.player = new PlayerImpl(ID.PLAYER, this);
    	//this.enemies = Optional.of(new ArrayList<>());
//        this.obstacles = Optional.of(new ArrayList<>());
        this.bullets = new ArrayList<>();
//        this.effects = new ArrayList<>();
//      this.shots = Optional.of(new ArrayList<>());
//      this.playerPowerUps = new ArrayList<>();
//      this.globalPowerUp = Optional.empty();
//        this.level = new Level(this);
        this.score = 0;
        this.freeze = false;
    }
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entity> getEntities() {
		final List<Entity> temp = new LinkedList<>();
		temp.add(player);
		
		temp.addAll(this.bullets);
		
//        temp.addAll(this.playerPowerUps);
//        
//        temp.addAll(this.effects);
//		
//		if(this.enemies.isPresent()) {
//			temp.addAll(this.enemies.get(i));
//		}
//		
//		if(this.obstacles.isPresent()) {
//			temp.addAll(this.enemies.get(i));
//		}
//		
//		if(this.shots.isPresent()) {
//			temp.addAll(this.enemies.get(i));
//		}
//		
//        if (this.globalPowerUp.isPresent()) {
//            temp.add(globalPowerUp.get());
//        }
        return temp;
	}

	@Override
	public GameStatus getStatus() {
		// TODO Auto-generated method stub
		return this.gameStatus;
	}

	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
//		return level.getLevel;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	@Override
	public PlayerImpl getPlayer() {
		return this.player;
	}

	@Override
	public List<BulletImpl> getBullets() {
		// TODO Auto-generated method stub
		return this.bullets;
	}

}

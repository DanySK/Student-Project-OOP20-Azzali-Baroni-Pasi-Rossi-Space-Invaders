package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class GameImpl implements Game{

   public static final int ARENA_WIDTH = 1600;

   public static final int ARENA_HEIGHT = 900;

   private static final int ENEMY_DEAD = 10;
   private static final int LEVEL_CLEARED = 1;
	
	private GameStatus gameStatus;
	private final PlayerImpl player;
	private final Optional<List<EnemyImpl>> enemies;
	private final Optional<List<AbstractMeteor>> meteors;
	private final List<BulletImpl> bullets;
	//private final List<Effect> effects;
    private final Optional<List<ShotEnemyImpl>> shots;
    //private final List<PlayerPowerUp> playerPowerUps;
    //private Optional<GlobalPowerUp> globalPowerUp;
//    private final InterfaceLevel level;
    private int score;
    private boolean freeze;
    
    public GameImpl() {
    	this.gameStatus = GameStatus.RUNNING;
    	this.player = new PlayerImpl(ID.PLAYER, this);
    	this.enemies = Optional.of(new ArrayList<>());
    	this.meteors = Optional.of(new ArrayList<>());
        this.bullets = new ArrayList<>();
//      this.effects = new ArrayList<>();
      this.shots = Optional.of(new ArrayList<>());
//      this.playerPowerUps = new ArrayList<>();
//      this.globalPowerUp = Optional.empty();
//        this.level = new Level(this);
        this.score = 0;
        this.freeze = false;
    }
	

	@Override
	public void update() {
//		this.playerPowerUps.forEach(ppu -> ppu.update());
		this.player.update();
		if(!this.freeze) {
//			this.enemies.get().forEach(e -> e.update());
			this.meteors.get().forEach(m -> m.update());
			this.shots.get().forEach(s -> s.update());
		}
//		this.bullets.get().forEach(b -> b.update());
//		this.effects.get().forEach(eff -> eff.update());
		
//		if(this.globalPowerUp.isPresent()) {
//			this.globalPowerUp.get().update();
//		}
	}
	
	public void nextLevel() {
//        if (this.effects.isEmpty() && this.enemies.isPresent() && this.enemies.get().isEmpty()) {
//            this.score += (LEVEL_CLEARED * this.level.getLevel() * this.player.getHealth() / 10);
//            this.clearEntitiesLeft();
//            this.level.nextLevelSingle();
//        }
	}
	
	private void clearEntitiesLeft() {
        this.meteors.get().forEach(a -> a.setDead());
        this.bullets.forEach(b -> b.setDead());
//        this.shots.get().forEach(s -> s.setDead());
//        this.enemies.get().forEach(e -> e.setDead());
//        this.effects.forEach(e -> e.setDead());
//        this.playerPowerUps.stream().filter(pu -> pu.isActivated()).forEach(pu -> pu.reset());
//        this.playerPowerUps.forEach(pu -> pu.setDead());
//        if (this.globalPowerUp.isPresent() && this.globalPowerUp.get().isActivated()) {
//            this.globalPowerUp.get().reset();
//            this.globalPowerUp.get().setDead();
//        }
//        this.removeDeadEntities();
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
//		if(this.meteors.isPresent()) {
//			temp.addAll(this.meteors.get(i));
//		}
//		
//		if(this.shots.isPresent()) {
//			temp.addAll(this.shots.get(i));
//		}
//		
//        if (this.globalPowerUp.isPresent()) {
//            temp.add(globalPowerUp.get());
//        }
        return temp;
	}

	@Override
	public GameStatus getStatus() {
		return this.gameStatus;
	}

	@Override
	public void checkCollision() {
		
	}
	
	private void checkForCollisions(final List<Entity> entities1, final List<Entity> entities2) {
		
	}
	
    private void removeDeadEntities() {
    	
    }
    
//    public Optional<List<AbstractEnemy>> getEnemies() {
//        return this.enemies;
//    }

    public List<ShotEnemyImpl> getShot() {
    	return this.shots.get();
    }
    
//  public List<PlayerPowerUp> getPlayerPowerUps() {
//  return this.playerPowerUps;
//}
//

    
//public void setGlobalPowerUp(final GlobalPowerUp globalPowerUp) {
//  this.globalPowerUp = Optional.ofNullable(globalPowerUp);
//}

	@Override
	public int getLevel() {
//		return level.getLevel;
		return 0;
	}

	@Override
	public int getScore() {
		return this.score;
	}

	@Override
	public PlayerImpl getPlayer() {
		return this.player;
	}

	@Override
	public List<BulletImpl> getBullets() {
		return this.bullets;
	}
	
    public List<AbstractMeteor> getObstacles() {
        return this.meteors.get();
    }
    
    public void setFreeze() {
        this.freeze = !this.freeze;
    }

}

package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import controller.Level;
import controller.LevelImpl;
import model.SpecialEffect.SpecialEffectT;
import model.powerup.GPowerUp;
import model.powerup.PPowerUp;

public class GameImpl implements Game{

   public static final int ARENA_WIDTH = 1600;
   public static final int ARENA_HEIGHT = 900;

   private static final int ENEMY_DEAD = 10;
   private static final int LEVEL_CLEARED = 1;
	
	private GameStatus gameStatus;
	private final PlayerImpl player;
	private final Optional<List<AbstractEnemy>> enemies;
	private final Optional<List<AbstractMeteor>> meteors;
	private final List<BulletImpl> bullets;
	private final List<SpecialEffect> effects;
    private final Optional<List<ShotEnemyImpl>> shots;
    private final List<PPowerUp> playerPowerUps;
    private Optional<GPowerUp> globalPowerUp;
    private final Level level;
    private int score;
    private boolean freeze;
    
    public GameImpl() {
    	this.gameStatus = GameStatus.RUNNING;
    	this.player = new PlayerImpl(ID.PLAYER, this);
    	this.enemies = Optional.of(new ArrayList<>());
    	this.meteors = Optional.of(new ArrayList<>());
        this.bullets = new ArrayList<>();
        this.effects = new ArrayList<>();
        this.shots = Optional.of(new ArrayList<>());
        this.playerPowerUps = new ArrayList<>();
        this.globalPowerUp = Optional.empty();
        this.level = new LevelImpl(this);
        this.score = 0;
        this.freeze = false;
    }
	

	@Override
	public void update() {
		this.playerPowerUps.forEach(ppu -> ppu.update());
		this.player.update();
		if(!this.freeze) {
			this.enemies.get().forEach(e -> e.update());
			this.meteors.get().forEach(m -> m.update());
			this.shots.get().forEach(s -> s.update());
		}
		this.bullets.forEach(b -> b.update());
		this.effects.forEach(eff -> eff.update());
		
		if(this.globalPowerUp.isPresent()) {
			this.globalPowerUp.get().update();
		}
	}
	
	public void nextLevel() {
        if (this.effects.isEmpty() && this.enemies.isPresent() && this.enemies.get().isEmpty()) {
            this.score += (LEVEL_CLEARED * this.level.getLevel() * this.player.getHealth());
            this.clearEntitiesLeft();
            this.level.nextLevel();
        }
	}
	
	private void clearEntitiesLeft() {
        this.meteors.get().forEach(a -> a.setDead());
        this.bullets.forEach(b -> b.setDead());
        this.shots.get().forEach(s -> s.setDead());
        this.enemies.get().forEach(e -> e.setDead());
        this.effects.forEach(e -> e.setDead());
        this.playerPowerUps.stream().filter(pu -> pu.isActivated()).forEach(pu -> pu.reset());
        this.playerPowerUps.forEach(pu -> pu.setDead());
        if (this.globalPowerUp.isPresent() && this.globalPowerUp.get().isActivated()) {
            this.globalPowerUp.get().reset();
            this.globalPowerUp.get().setDead();
        }
        this.removeDeadEntities();
	}

	@Override
	public List<Entity> getEntities() {
		final List<Entity> temp = new LinkedList<>();
		temp.add(player);
		
		temp.addAll(this.bullets);
		
        temp.addAll(this.playerPowerUps);
//        
        temp.addAll(this.effects);
//		
		if(this.enemies.isPresent()) {
			temp.addAll(this.enemies.get());
		}
		
		if(this.meteors.isPresent()) {
			temp.addAll(this.meteors.get());
		}
		
		if(this.shots.isPresent()) {
			temp.addAll(this.shots.get());
		}
		
        if (this.globalPowerUp.isPresent()) {
            temp.add(globalPowerUp.get());
        }
        
        return temp;
	}

	@Override
	public GameStatus getStatus() {
		return this.gameStatus;
	}

	@Override
	public void checkCollision() {
		//scommentare dopo aver fatto le meteore
        this.checkForCollisions(Arrays.asList(this.player), this.meteors.get().stream().collect(Collectors.toList()));

        this.checkForCollisions(Arrays.asList(this.player), this.enemies.get().stream().collect(Collectors.toList()));
        this.checkForCollisions(this.enemies.get().stream().filter(e -> !e.isDead()).collect(Collectors.toList()), 
                this.bullets.stream().filter(b -> !b.isDead()).collect(Collectors.toList()));
        this.checkForCollisions(this.meteors.get().stream().filter(e -> !e.isDead()).collect(Collectors.toList()), 
                this.bullets.stream().filter(b -> !b.isDead()).collect(Collectors.toList()));
        this.checkForCollisions(Arrays.asList(this.player), this.shots.get().stream().collect(Collectors.toList()));
        if (this.globalPowerUp.isPresent() && !this.globalPowerUp.get().isActivated() && this.globalPowerUp.get().getHitbox().intersects(this.player.getHitbox())) {
            this.globalPowerUp.get().setGame(this);
            this.globalPowerUp.get().collide(this.player);
        }
        this.checkForCollisions(Arrays.asList(this.player), this.playerPowerUps.stream().filter(pu -> !pu.isActivated()).collect(Collectors.toList()));
        if (this.player.isDead()) {
        this.gameStatus = GameStatus.LOST;
        } else {
        this.nextLevel();
        }
        this.removeDeadEntities();
	}
	
	private void checkForCollisions(final List<EntityImpl> entities1, final List<EntityImpl> entities2) {
        entities1.forEach(e1 -> entities2.stream()
                .filter(e2 -> !e2.isDead())
                .filter(e2 -> e2.getHitbox().intersects(e1.getHitbox()))
                .forEach(e2 -> {
                    if (!e2.getID().equals(ID.POWER_UP)) {
                        e1.collide(e2);
                    }
                    e2.collide(e1);
                }));
	}
	
    private void removeDeadEntities() {
        final List<AbstractEnemy> deadEnemies = this.enemies.get().stream()
                .filter(e -> e.isDead())
                .peek(e -> this.score += (ENEMY_DEAD * this.level.getLevel()))
                .peek(e -> this.effects.add(new SpecialEffect(ID.EFFECT, e.getPosition(), e.getHitbox(), SpecialEffectT.EXPLOSION)))
                .collect(Collectors.toList());
        deadEnemies.forEach(e -> this.enemies.get().remove(e));
        final List<AbstractMeteor> deadObstacles = this.meteors.get().stream().filter(a -> a.isDead()).collect(Collectors.toList());
        deadObstacles.forEach(o -> this.meteors.get().remove(o));
        this.shots.get().removeIf(s -> s.isDead());
        if (this.globalPowerUp.isPresent() && this.globalPowerUp.get().isDead()) {
            this.globalPowerUp = Optional.empty();
        }
    this.bullets.removeIf(b -> b.isDead());
    this.playerPowerUps.removeIf(pu -> pu.isDead());
    this.effects.removeIf(e -> e.isDead());
    }
    
    public Optional<List<AbstractEnemy>> getEnemies() {
        return this.enemies;
    }

    public List<ShotEnemyImpl> getShot() {
    	return this.shots.get();
    }
    
  public List<PPowerUp> getPlayerPowerUps() {
	  return this.playerPowerUps;
  }

  public void setGlobalPowerUp(final GPowerUp globalPowerUp) {
	  this.globalPowerUp = Optional.ofNullable(globalPowerUp);
  	}

	@Override
	public int getLevel() {
		return level.getLevel();
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
	
    public List<AbstractMeteor> getMeteor() {
        return this.meteors.get();
    }
    
    public void setFreeze() {
        this.freeze = !this.freeze;
    }

}

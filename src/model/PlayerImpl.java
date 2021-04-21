package model;

import java.awt.Rectangle;

import utility.Clamp;
import utility.Pair;


public final class PlayerImpl extends EntityImpl implements Player{

	private static final int DAMAGE_MULTIPLIER = 50;//10
    private static final int WIDTH = GameImpl.ARENA_WIDTH / 20;
    private static final int HEIGHT = WIDTH + WIDTH / 100;
    private static final int DEFINITLY_NOT_SHOT_COOLDOWN = 20;
    private int health = 100;
    private int shootCD = DEFINITLY_NOT_SHOT_COOLDOWN;
    private int shotReady;
    private int shield;
    private static int Y_INIZIAL = 900;
    private final GameImpl gameImpl;
    
    public PlayerImpl(final ID id, final GameImpl gameImpl) {
    	super(new Pair<Integer, Integer>(GameImpl.ARENA_WIDTH / 2, Y_INIZIAL), 0, 0, id);
    	this.gameImpl = gameImpl;
    	setHitbox(new Rectangle(this.getPosition().getX(),this.getPosition().getY(),WIDTH,HEIGHT));
    }

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}

	@Override
	public void setHealth(int lifePoints) {
		this.health = lifePoints;
	}

	@Override
	public int getCoolDown() {
		// TODO Auto-generated method stub
		return this.shootCD;
	}

	@Override
	public void setCoolDown(int coolDown) {
		this.shootCD = coolDown;
	}

	@Override
	public int getShield() {
		// TODO Auto-generated method stub
		return this.shield;
	}

	@Override
	public void setSHield(int shieldLife) {
		this.shield = shieldLife;		
	}

	@Override
	public int getShotReady() {
		// TODO Auto-generated method stub
		return this.shotReady;
	}

	@Override
	public void setShotReady(int time) {
		this.shotReady = time;
	}

	@Override
	public void resetPosition() {
		this.setPosition(new Pair<Integer, Integer>(GameImpl.ARENA_WIDTH / 2, Y_INIZIAL));
	}

	@Override
	public void update() {
		this.getPosition().setX(this.getPosition().getX() + this.getSpeed().getX());
		this.getPosition().setY(this.getPosition().getY() + this.getSpeed().getY());
		
		this.getPosition().setX(Clamp.clamp(this.getPosition().getX(), WIDTH / 2, GameImpl.ARENA_WIDTH - WIDTH / 2));
        this.getPosition().setY(Clamp.clamp(this.getPosition().getY(), HEIGHT / 2, GameImpl.ARENA_HEIGHT - HEIGHT / 2));

    this.setHitbox(new Rectangle(this.getPosition().getX() - WIDTH / 2, this.getPosition().getY() - HEIGHT / 2, WIDTH, HEIGHT));
	}

	@Override
	public void collide(Entity entity) {
		if (this.shield == 0) {
			this.health -= DAMAGE_MULTIPLIER * gameImpl.getLevel();
		} else if (this.shield > 0 && this.shield < DAMAGE_MULTIPLIER * gameImpl.getLevel()) {
            final int tempDamageOverShieldValue = DAMAGE_MULTIPLIER * gameImpl.getLevel() - this.shield;
            this.health -= tempDamageOverShieldValue;
            this.shield = 0;
        } else {
            this.shield -= DAMAGE_MULTIPLIER * gameImpl.getLevel();
        }
		
		if (this.health <= 0) {
        this.setDead();
        }
	}
	
}

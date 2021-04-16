package model.powerup;

import java.awt.Rectangle;

import controller.ChronometerEntity;
import controller.GameLoop;
import model.Entity;
import model.ID;
import model.Player;
import utility.Pair;

public abstract class PowerUpImpl extends ChronometerEntity implements PowerUp {
	
	
	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;
	
	public static final int LIFE_T = GameLoop.FPS *5;


	private final PowerUpT type;
	private boolean isActiveted;
	private Player player;

	

	public PowerUpImpl(final Pair<Integer, Integer> position, final int veloX,final int veloY, final ID id, final PowerUpT type) {
		super(position, veloX, veloY, id, type.getLifetime());
		this.type = type;
		this.isActiveted = false;
		this.setHitbox(new Rectangle(this.getPosition().getX() - WIDTH / 2, this.getPosition().getX() - HEIGHT / 2, WIDTH, HEIGHT));
		
	}



	@Override
	public void InsertBuff() {
		if(this.isActiveted == false || this.getType().isRequiringUpdate()) {
			this.InsertEffect();
			this.isActiveted = true;
		}
		
	}
	protected abstract void InsertEffect();


	@Override
	public abstract void reset();
	


	@Override
	public boolean isActivated() {
		return this.isActiveted;
	}



	@Override
	public void update() {
		if(this.isActiveted == false){
			this.getPosition().setX(this.getPosition().getX() + this.getSpeed().getX());
			this.getPosition().setY(this.getPosition().getY() + this.getSpeed().getY());
			this.setHitbox(new Rectangle(this.getPosition().getX() - WIDTH / 2, this.getPosition().getY()));
			//capire come gestire la caduta dei power up dall'alto al basso//this.bounce();
		}else {
			this.setS();
			if(this.isEnded() == false) {
				this.tick();
				this.InsertBuff();
			}else {
				this.reset();
				this.setDead();
			}
		}
		
	}
	protected abstract void setS();
	public final PowerUpT getType() {
		return this.type;
	}
	

	@Override
	public void collide(final Entity entity) {
		if(entity instanceof Player) {
			this.player = (Player)entity;
			this.InsertBuff();
			this.setPosition(entity.getPosition());
			this.setHitbox(entity.getHitbox());
		}
		
	}

}

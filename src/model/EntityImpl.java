package model;

import java.awt.Rectangle;

import utility.Pair;

public abstract class EntityImpl implements Entity {
	
	private final ID id;
	private Rectangle hitbox; 
	private Pair<Integer, Integer> position;
	private boolean dead;
	private Pair<Integer, Integer> speed;
	
	
	public EntityImpl(final Pair<Integer,Integer> position, final int speedX, final int speedY, final ID id) {
		this.position = position;
		this.id = id;
		this.hitbox = null;
		this.speed = new Pair<>(speedX, speedY);
	}
	
	public EntityImpl(final ID id) {
		this(null, 0, 0, id);
	}

	@Override
	public abstract void update(); 
		// TODO Auto-generated method stub
		

	@Override
	public abstract void collide(Entity entity);
		// TODO Auto-generated method stub
		
	

	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return this.hitbox;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return this.dead;
	}

	@Override
	public Pair<Integer, Integer> getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public final ID getID() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setHitbox(final Rectangle hitbox) {
		this.hitbox = hitbox;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDead() {
		this.dead = true;
		// TODO Auto-generated method stub
		
	}
	
	public void setAlive() {
		this.dead = false;
	}

	@Override
	public final void setPosition(final Pair<Integer, Integer> position) {
		this.position = position;
		// TODO Auto-generated method stub
		
	}
	
	public void setSpeed(final int speedX, final int speedY) {
		this.speed = new Pair<Integer, Integer>(speedX, speedY);
	}
	
}

package model;

import utility.Pair;

public abstract class AbstractMeteor extends EntityImpl implements Meteor{

	public AbstractMeteor(final Pair<Integer,Integer> position,final int velocityX,final int velocityY,final int Length,final ID id) {
		super(position,velocityX,velocityY,id);
		//this.setHitbox(//new MeteorHitBox);
	}
	
	public void update() {
		this.getPosition().setX(this.getPosition().getX() +this.getSpeed().getX());
		this.getPosition().setY(this.getPosition().getY() + this.getSpeed().getY());
	    //((MeteorHitBox))
		this.updateEntity();
	}
	
	protected abstract void updateEntity();

}

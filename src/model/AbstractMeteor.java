package model;

import utility.Pair;

public abstract class AbstractMeteor extends EntityImpl implements Meteor{

	public AbstractMeteor(final Pair<Integer,Integer> position,final int velocityX,final int velocityY,final int Length,final ID id) {
		super(position,velocityX,velocityY,id);
		this.setHitbox(new MeteorHitBox(position,Length));
	}
	
	public void update() {
		this.getPosition().setY(this.getPosition().getY() + this.getSpeed().getY());
	    ((MeteorHitBox) (this.getHitbox())).updteHitBox(this.getPosition());
		this.updateEntity();
	}
	
	protected abstract void updateEntity();

}

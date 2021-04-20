package model;

import utility.Pair;

public class MeteorImpl extends AbstractMeteor{
	private int meteor_life=3;
	
	
	public MeteorImpl(Pair<Integer, Integer> position, int velocityX, int velocityY, int Length, ID id) {
		super(position, velocityX, velocityY, Length, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void updateEntity() {
		// TODO Auto-generated method stub
		if(((MeteorHitBox) (this.getHitbox())).isOutBorder()) {
			this.setDead();
		}
		
	}

	@Override
	public void collide(Entity entity) {
		// TODO Auto-generated method stub
		this.meteor_life--;
		if(this.meteor_life <= 0) {
			this.setDead();
		}
	}
	


}

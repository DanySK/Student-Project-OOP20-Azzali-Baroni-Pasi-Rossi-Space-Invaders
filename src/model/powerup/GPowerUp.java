package model.powerup;

import java.awt.Rectangle;

import model.GameImpl;
import model.ID;
import utility.Pair;

public class GPowerUp extends PowerUpImpl{
	private GameImpl Game;

	public GPowerUp(final Pair<Integer, Integer> position, final int veloX, final int veloY, final ID id, final PowerUpT type) {
		super(position, veloX, veloY, id, type);
	}

	@Override
	protected void InsertEffect() {
		this.Game.setFreeze();
		
	}

	@Override
	public void reset() {
		if(this.getType().equals(PowerUpT.FREEZE)) {
			this.Game.setFreeze();
		}
		
	}

	@Override
	protected void setS() {
		if(this.getTimeLeft() == this.getType().getLifetime()) {
			this.setPosition(new Pair<>(0,0));
			this.setSpeed(0,0);
			this.setHitbox(new Rectangle(0,0,GameImpl.ARENA_WIDTH,GameImpl.ARENA_HEIGHT));
		}
		
	}

}

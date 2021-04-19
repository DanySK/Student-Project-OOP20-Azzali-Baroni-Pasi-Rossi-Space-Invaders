package model.powerup;

import java.awt.Rectangle;

import model.GameImpl;
import model.ID;
import utility.Pair;

public class GPowerUp extends PowerUpImpl{
	
	private GameImpl game;

	

	public GPowerUp(Pair<Integer, Integer> position, int veloX, int veloY, ID id, PowerUpT type) {
		super(position, veloX, veloY, id, type);
		
	}

	@Override
	protected void InsertEffect() {
		 this.game.setFreeze();
		
	}

	@Override
	public void reset() {
		if (this.getType().equals(PowerUpT.FREEZE)) {
            this.game.setFreeze();
        }
		
	}

	@Override
	protected void setS() {
		if (this.getTimeLeft() == this.getType().getLifetime()) {
            this.setPosition(new Pair<>(0, 0));
            this.setSpeed(0, 0);
            this.setHitbox(new Rectangle(0, 0, GameImpl.ARENA_WIDTH, GameImpl.ARENA_HEIGHT));
        }
		
	}
	
    public void setGame(final GameImpl game) {
        this.game = game;
    }

}

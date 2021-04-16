package model.powerup;

import controller.PowerUp.Strategy;
import model.ID;
import model.Player;
import utility.Clamp;
import utility.Pair;

public class PPowerUp extends PowerUpImpl{
	private static final int STANDARD_HEALTH = 20;
	private static final int STANDARD_SPEED_BOOST = 2;
	private static final int STANDARD_FIRE_RATE_BOOST = 2;
	private static final int STANDARD_SHIELD = 100;
	private final Strategy strategy;

	public PPowerUp(final Pair<Integer, Integer> position, final int veloX, final int veloY,final ID id, final PowerUpT type,final Strategy strategy) {
		super(position, veloX, veloY, id, type);
		this.strategy = strategy;
	}

	@Override
	public void InsertStrategy() {
		
		
	}

	@Override
	public void reset() {
		 final Player player = this.getEntityStrategy();
	        if (this.getType().equals(PowerUpT.FIRE_BOOST)) {
	            //player.setShotCD(player.getShotCD() + this.strategy.multiplyEffect(STANDARD_FIRE_RATE_BOOST));
	        
	        }
	}

	@Override
	public boolean isActivated() {
		return false;
	}

	@Override
	protected void InsertEffect() {
		final Player player = this.getEntityStrategy();
		if(this.getType().equals(PowerUpT.HEALTH)) {
			player.setHealth(Clamp.clamp(player.getHealth() + this.strategy.multiplyEffect(STANDARD_HEALTH), 0, 100));
        } else if (this.getType().equals(PowerUpT.FIRE_BOOST)) {
            //player.setShotCD(player.getShotCD() - this.strategy.multiplyEffect(STANDARD_FIRE_RATE_BOOST));
        } else {
            if (!this.isActivated()) {
                //player.setShield(this.strategy.multiplyEffect(STANDARD_SHIELD));
            } else if (player.getShield() == 0) {
                this.setDead();
            }
        }
		
	}

	@Override
	protected void setS() {
		/*this.setPosition(this.getEntityStrategy());
		this.setHitbox(this.getEntityStrategy());*/
		
	}

	
}

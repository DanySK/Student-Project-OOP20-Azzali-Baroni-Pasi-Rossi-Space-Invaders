package model.powerup;

import controller.PowerUp.Strategy;
import model.ID;
import model.Player;
import model.PlayerImpl;
import utility.Clamp;
import utility.Pair;

public class PPowerUp extends PowerUpImpl{
	private static final int STANDARD_HEALTH = 20;
	//private static final int STANDARD_SPEED_BOOST = 2;
	private static final int STANDARD_FIRE_RATE_BOOST = 2;
	private static final int SHIELD_S = 100;
	private final Strategy strategy;

	public PPowerUp(final Pair<Integer, Integer> position, final int veloX, final int veloY,final ID id, final PowerUpT type,final Strategy strategy) {
		super(position, veloX, veloY, id, type);
		this.strategy = strategy;
	}


	@Override
	public void reset() {
		 final Player player = this.getEntityStrategy();
	        if (this.getType().equals(PowerUpT.FIRE_BOOST)) {
	            player.setCoolDown(player.getCoolDown() + this.strategy.multiplyEffect(STANDARD_FIRE_RATE_BOOST));
	         }else if(this.getType().equals(PowerUpT.SHIELD)){
	        	player.setSHield(0);
	        }
	}


	@Override
	protected void InsertEffect() {
		final PlayerImpl player = this.getEntityStrategy();
		if(this.getType().equals(PowerUpT.HEALTH)) {
			player.setHealth(Clamp.clamp(player.getHealth() + this.strategy.multiplyEffect(STANDARD_HEALTH), 0, 100));
        } else if (this.getType().equals(PowerUpT.FIRE_BOOST)) {
            player.setCoolDown(player.getCoolDown() - this.strategy.multiplyEffect(STANDARD_FIRE_RATE_BOOST));
        } else {
        	if(this.isActivated() == false) {
        		player.setSHield(this.strategy.multiplyEffect(SHIELD_S));
        	}else if(player.getShield() == 0) {
        		this.setDead();
        	}
        }
		
	}

	@Override
	protected void setS() {
		this.setPosition(this.getEntityStrategy().getPosition());
		this.setHitbox(this.getEntityStrategy().getHitbox());
	}

	
}

package controller.PowerUp;

import java.util.List;
import java.util.Optional;
import java.util.Random;


import model.GameImpl;
import model.ID;
import model.powerup.GPowerUp;
import model.powerup.PPowerUp;
import model.powerup.PowerUpImpl;
import model.powerup.PowerUpT;
import utility.Clamp;
import utility.Pair;

public class SpawnerP {
	
	private static final int PROBABILITY_POWER_UP = 50;
	
	
	private final int spawnFrezee;

	
	public SpawnerP() {
		final Random random = new Random();
		this.spawnFrezee = random.nextInt(PROBABILITY_POWER_UP);
	}
	
	public List<PPowerUp> SpawnPowerUpPlayer(final int level){
		return null;
		//implementare dopo aver fatto il livello
	}
	
	private Pair<Integer,Integer> generatePosition(){
		final Random random = new Random();
        final int xP = Clamp.clamp(random.nextInt(GameImpl.ARENA_WIDTH), 0 + PowerUpImpl.WIDTH / 2, GameImpl.ARENA_WIDTH - PowerUpImpl.WIDTH / 2);
        final int yP = Clamp.clamp(random.nextInt(GameImpl.ARENA_HEIGHT), 0 + PowerUpImpl.HEIGHT / 2, GameImpl.ARENA_HEIGHT - PowerUpImpl.HEIGHT / 2);
        return new Pair<Integer, Integer>(xP, yP);
	}
	
	private int generateVelocity() {
        final Random random = new Random();
        return random.nextInt(PowerUpT.values().length) + 1;
    }
	
	 public Optional<GPowerUp> spawnGlobalPowerUp() {
	        final Random random = new Random();
	        final int Number;
	        final PowerUpT type;
	        Number = random.nextInt(PROBABILITY_POWER_UP);
	         if (Number == this.spawnFrezee) {
	            type = PowerUpT.FREEZE;
	        } else {
	            return Optional.empty();
	        }
	        return Optional.of(new GPowerUp(this.generatePosition(), this.generateVelocity(), this.generateVelocity(),ID.POWER_UP, type));
	    }
	
}

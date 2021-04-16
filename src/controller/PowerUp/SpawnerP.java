package controller.PowerUp;

import java.util.ArrayList;
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
	private static final int POWERUP_PROBABILITY =60;
	
	private final int spawnFreez;
	
	public SpawnerP() {
		final Random random = new Random();
		this.spawnFreez = random.nextInt(POWERUP_PROBABILITY);
		
	}

	public List<PPowerUp>SpawnPlayerP(final int level){
		final List<PPowerUp> list = new ArrayList<>();
		final Random random = new Random();
		//finire
		
		return list;
	}
	
	private Pair<Integer,Integer> GeneratePosition(){
		final Random random = new Random();
		final int XP = Clamp.clamp(random.nextInt(GameImpl.ARENA_WIDTH),0 + PowerUpImpl.WIDTH / 2, GameImpl.ARENA_WIDTH - PowerUpImpl.WIDTH / 2);
		final int YP = Clamp.clamp(random.nextInt(GameImpl.ARENA_HEIGHT),0 + PowerUpImpl.HEIGHT / 2, GameImpl.ARENA_HEIGHT - PowerUpImpl.HEIGHT / 2);
		return new Pair<Integer, Integer>(XP,YP);
	}
	
	private int GenerateVelocity() {
		final Random random = new Random();
		return random.nextInt(PowerUpT.values().length) + 1;
	}
	
	public Optional<GPowerUp> SpawnGlobalP(){
		final int rand;
        final Random random = new Random();
        final PowerUpT type;
        rand = random.nextInt(POWERUP_PROBABILITY);
        if(rand == this.spawnFreez) {
        	type = PowerUpT.FREEZE;
        }
        else {
        	return Optional.empty();
        }
        return Optional.of(new GPowerUp(this.GeneratePosition(),this.GenerateVelocity(),this.GenerateVelocity(),ID.POWER_UP,type));
	}
}

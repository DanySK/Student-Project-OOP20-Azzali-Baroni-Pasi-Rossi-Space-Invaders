package controller;


import java.util.Random;
import model.GameImpl;
import model.ID;
import model.MeteorImpl;
import utility.Pair;

public class MeteorController {

	private final Random random = new Random(100);
	private static final int LENGTH = 50;
	private static final int VELOCITY = 5;
	
	private Pair<Integer,Integer> RandomSpawn(){
		return new Pair<Integer,Integer>(this.random.nextInt(GameImpl.ARENA_WIDTH - 2 * LENGTH) + LENGTH, LENGTH);
		//per ora va bene poi si vedra
	}
	
	public MeteorImpl createMeteor() {
		return new MeteorImpl(this.RandomSpawn(), VELOCITY, VELOCITY, LENGTH, ID.OBSTACLE);
	}
}

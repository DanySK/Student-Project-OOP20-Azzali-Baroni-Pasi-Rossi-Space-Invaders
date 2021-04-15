package controller;

import model.Entity;
import model.EntityImpl;
import model.ID;
import utility.Pair;

public abstract class ChronometerEntity extends EntityImpl implements Chronometer {


	private final Chronometer chronometer;
	
	public ChronometerEntity(final Pair<Integer, Integer>position,final int veloX,final int veloY,final ID id, final int chronometer ) {
		super(position,veloX,veloY,id);
		this.chronometer = new ChronometerImpl(chronometer);
	}

	@Override
	public abstract void update();
	@Override
	public abstract void collide(Entity entity);
	
	@Override
	public void tick() {
		this.chronometer.tick();
	}


	
	@Override
	public int getTimeLeft() {
		return chronometer.getTimeLeft();
	}


	@Override
	public boolean isEnded() {
		return chronometer.isEnded();
	}

	
	

}

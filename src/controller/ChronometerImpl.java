package controller;

public class ChronometerImpl implements Chronometer {

	private int chronometer;
	
	public ChronometerImpl(final int chronometer) {
		this.chronometer = chronometer;
	}
	@Override
	public void tick() {
		this.chronometer--;
		
	}

	@Override
	public boolean isEnded() {
		return this.chronometer <= 0;
	}

	@Override
	public int getTimeLeft() {
		return this.chronometer;
	}

}

package controller.PowerUp;

public final class HighStrategy implements Strategy{

	private static final double MULTI =5;
	@Override
	public int multiplyEffect(int effect) {
		return (int)(effect * MULTI);
	}

}

package controller.PowerUp;

public final class BasicStrategy implements Strategy {

	@Override
	public int multiplyEffect(final int effect) {
		
		return effect * 2;
	}

}

package controller.PowerUp;

public final class BasicStrategy implements Strategy {

	@Override
	public int multiplyEffect(int effect) {
		
		return effect * 2;
	}

}

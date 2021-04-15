package utility;

public class Clamp {
	
	private Clamp() {
	}
	
	public static int clamp(final int var, final int min, final int max) {
		return var < min ? min : (var > max ? max : var);
	}

}

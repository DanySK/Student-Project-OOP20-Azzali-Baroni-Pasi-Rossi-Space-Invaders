package model;

import java.awt.Rectangle;

import utility.Pair;

public class MeteorHitBox extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final int Length;
    
    public MeteorHitBox(final Pair<Integer,Integer> position, final int Length) {
		super(position.getX().intValue() - Length / 2, position.getY().intValue() - Length / 2, Length, Length);
    	this.Length = Length;   	
    }
    
    public void updteHitBox(final Pair<Integer,Integer> position) {
    	this.setLocation(position.getX().intValue() - this.Length/2, position.getY().intValue() - this.Length/2);
    }
    
    public boolean isOutBorder() {
    	final Rectangle border = new Rectangle(0, 0, GameImpl.ARENA_WIDTH, GameImpl.ARENA_HEIGHT); 
    	return !border.contains(this) && !border.intersects(this);
    }
}

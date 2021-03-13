package model;

public interface Player extends Entity{
	
	public void setPosition(Double PosX);
	
	public double getPosY();
	
	public double getPosX();
	
	public int getWidthPlayer();
	
	public int getHeightPlayer();
	
	public String getPlayerImagePath();
}

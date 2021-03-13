package model;

public interface Enemy extends Entity{
	
	public double getPosY();
	
	public double getPosX();
	
	public int getWidthEnemy();
	
	public int getHeightEnemy();
	
	public String getEnemyImagePath();

}

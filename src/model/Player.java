package model;

public interface Player extends Entity{
	
	public void setPosition(double PosX);

	public void setInitialLife();

	public int getLivePlayer();

	public double getSpeedPlayer();
	
	public int getDamagePlayer();
	
	public void setInitialSpeed();

	public void setInitialDamage();

	public void setDecrementLife();

	public void setIncrementSpeed(double bonusSpeed);
	
	public void setIncrementLife();
	
	public void setIncrementDamege(int BonusDamage);

}

package model;



public class PlayerImpl implements Player{

	private final static int DIMENSION_SHIP_PLAYER = 60;
	private final static int LIFE_INITIAL=3;
	private final static double SPEED = 0.5;
	private final static int DAMAGE_PLAYER = 1;
	
	private int life_player,damage_player;
	private double speed_player;
	//player_img
	
	
	public PlayerImpl() {	
	}
	
	/**
	 * method to set the initial and the new position of the player 
	 */
	public void setPosition() {}
	
	/**
	 * method for set initial life of player
	 */
	public void setInitialLife() {
		this.life_player = LIFE_INITIAL;
	}
	
	/**
	 * method to get the life of Player
	 * @return remaining life of the player
	 */
	public int getLivePlayer() {
		return this.life_player;
	}
	
	/**
	 * method to get the speed of Player
	 * @return remaining speed of the player
	 */
	public double getSpeedPlayer() {
		return this.speed_player;
	}
	
	/**
	 * method to get the damage of Player
	 * @return remaining damage of the player
	 */
	public int getDamagePlayer() {
		return this.damage_player;
	}
	
	/**
	 * set the initial speed of the player
	 */
	public void setInitialSpeed() {
		this.speed_player = SPEED;
		
		//aggiungere un metodo per gestire il ritorno alla velocita normale del player
	}
	
	/**
	 * 
	 */
	public void setInitialDamage() {
		this.damage_player = DAMAGE_PLAYER;
	}
	
	/**
	 * set the life of the player after take damage
	 *  
	 */
	public void setDecrementLife() {
		this.life_player -= 1;	
	}
	
	/**
	 * set the new speed of the player after take the bonus of speed
	 * @param bonusSpeed
	 */
	public void setIncrementSpeed(double bonusSpeed) {
		this.speed_player *= bonusSpeed;
		//avevo pensato che ci potevano essere piu tipologie di bonus velocita
		//con varie "percentuali" di velocita per esempio 0.1 0.2 0.3
	}
	/**
	 * set the new life of the player after take the bonus of life
	 * 
	 */
	public void setIncrementLife() {
		this.speed_player += 1;
	}
	
	/**
	 * set the new life of the player after take the bonus of life
	 * 
	 */
	public void setIncrementDamege(int BonusDamage) {
		this.damage_player += BonusDamage;
		//bonus del danno come sopra ma non in percentiali ma in interi
		//per esempio + 1 2 3 
	}
	
}
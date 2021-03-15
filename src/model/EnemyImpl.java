package model;

public class EnemyImpl implements Entity{
	
	private static final int WIDTH_ENEMY=20;
	private static final int HEIGHT_ENEMY=30;
	private final static int LIFE_ENEMY=1;
	private final static double SPEED = 0.2;
	private final static int DAMAGE_ENEMY = 1;
	
	private double posX;
    private double posY;
    private final String EnemyImagePath;
	
	private int life_Enemy,damage_Enemy;
	private double speed_Enemy;
	
	public EnemyImpl(double posX, double posY, int life_Enemy, double speed_Enemy) {
		// TODO Auto-generated constructor stub
		this.posX = posX;
		this.posY = posY;
		this.life_Enemy = life_Enemy;
		this.speed_Enemy = speed_Enemy;
		this.EnemyImagePath = "Enemy1.png";
		//pensavo di mettere tre possibili nemici differenziati dal codice intero della vita(life_ENEMY)
		//ogni nemico ha una propria foto 
		
	}
	
	@Override
	public double getPosX() {
		// TODO Auto-generated method stub
		return this.posX;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	@Override
	public double getPosY() {
		// TODO Auto-generated method stub
		return this.posY;
	}
	
	public void setPosY(double posY) {
		this.posY = posY;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.WIDTH_ENEMY;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.HEIGHT_ENEMY;
	}
	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.EnemyImagePath;
	}

}

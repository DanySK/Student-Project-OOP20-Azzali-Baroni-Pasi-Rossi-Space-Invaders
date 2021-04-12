
package controller;


import javafx.scene.image.Image;
import model.MeteorImpl;

public class SpawnMeteors extends Thread{

	private static final int TIME = 2;
	private static final int LIMIT = 18000;
	private static final int SLEEP_TIME = 2000;
	private double MeteorsSpawn;
	private double BonusSpawn;
	private GameLoop gameloop;
	private MeteorController meteorController = new MeteorController();
	private Image m= new Image(getClass().getResourceAsStream("/meteorBrown_big1.png"));
	
	public SpawnMeteors(final GameLoop gameloop) {
		this.MeteorsSpawn = (Math.random() * LIMIT) + TIME;
		this.BonusSpawn = (Math.random()*LIMIT)+ TIME;
		this.gameloop = gameloop;
		
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.gameloop.isActive()) {
			
			try {
				this.BonusSpawn -=TIME;
				if(this.BonusSpawn < 0) {
					System.out.println("ecco qua un bonus");
                    this.BonusSpawn = (Math.random() * LIMIT) + TIME;
				}
				this.MeteorsSpawn -= TIME;
				if(this.MeteorsSpawn < 0) {
					meteorController.addMeteor(new MeteorImpl(this.m));
					this.MeteorsSpawn = (Math.random() * LIMIT) + TIME;
				}
				Thread.sleep(SLEEP_TIME);
			}
			catch (InterruptedException e) {
                System.exit(0);
            }
			
		}
		//super.run();
	}

}

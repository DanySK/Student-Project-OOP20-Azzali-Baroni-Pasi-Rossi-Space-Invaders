package controller;


public class SpawnMeteors extends Thread{

	private static final int TIME = 2;
	private static final int LIMIT = 18000;
	private static final int SLEEP_TIME = 2000;
	private double MeteorsSpawn;
	private GameLoop gameloop;
	
	public SpawnMeteors(final GameLoop gameloop) {
		this.MeteorsSpawn = (Math.random() * LIMIT) + TIME;
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
				this.MeteorsSpawn -= TIME;
				if(this.MeteorsSpawn < 0) {
					System.out.println("ecco qua una meteoraaaa");
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

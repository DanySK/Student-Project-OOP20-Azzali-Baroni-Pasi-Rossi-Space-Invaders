package controller;

import controller.PowerUp.SpawnerP;
import model.ID;
import model.BasicEnemy;
import model.BossEnemy;
import model.EnemyBehaviour;
import model.GameImpl;

public class LevelImpl implements Level{
	
	private final GameImpl gameImpl;
	private static final int LEVEL_BOSS = 5;
    private final SpawnerP spawnerPowerUp;
    private final MeteorController meteors;
    private final EnemyBehaviour bossEnemy;
    private int myLevel = 1;
    private int currentLevel = 1;
    private int nEnemy = 2;
    private int nMeteor = 1;
    
    public LevelImpl(final GameImpl gameImpl) {
    	this.gameImpl = gameImpl;
    	this.spawnerPowerUp = new SpawnerP();
    	this.meteors = new MeteorController();
    	this.bossEnemy = new BossEnemy(this.gameImpl);
    	createSomething();
    }
    
    private void createPowerUp() {
            gameImpl.getPlayerPowerUps().addAll(this.spawnerPowerUp.SpawnPowerUpPlayer(this.currentLevel));
            gameImpl.setGlobalPowerUp(this.spawnerPowerUp.spawnGlobalPowerUp().orElse(null));
    }
    
    private void create(final int number, final ID id) {
        switch (id) {
        case BASIC_ENEMY: 
        	for (int i = 0; i < number; i++) {
            gameImpl.getEnemies().get().add(new BasicEnemy(gameImpl).createThisEnemy());
        	}
        break;

        case BOSS_ENEMY: 
        	gameImpl.getEnemies().get().add(bossEnemy.createThisEnemy());
        break;
        
        case OBSTACLE: 
        	for (int i = 0; i < number; i++) {
            gameImpl.getObstacles().add(meteors.createMeteor());
        }

        default: 
            break;
        }
    }
    
    private void createSomething() {
    	createPowerUp();
    	switch (myLevel) {
        case 1: 
        	create(nEnemy, ID.BASIC_ENEMY);
        	create(nMeteor, ID.OBSTACLE);
        break;
        case LEVEL_BOSS: 
        	create(1, ID.BOSS_ENEMY);
        	create(nMeteor, ID.OBSTACLE);
        break;
        default:
            break;
        }
    }

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.currentLevel;
	}

	@Override
	public void resetLevel() {
        myLevel = 1;
        currentLevel = 1;
        nEnemy = 2;
        nMeteor = 1;
	}

	@Override
    public void nextLevel() {
		gameImpl.getPlayer().resetPosition();
        currentLevel++;
        myLevel++;
        if (myLevel <= LEVEL_BOSS) {
            createSomething();
        } else {
            myLevel = 1;
            nEnemy++;
            nMeteor++;
            createSomething();
        }
    }

}

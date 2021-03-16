package controller;

import model.EnemyImpl;
import model.Entity;
import view.EnemyView;
import view.EnemyViewImpl;



public class EnemyControllerImpl implements EnemyController{
	
	public static final int SCREEN_WIDTH = 810;

	
	private double newPosition;
	private final EnemyImpl enemy;
	private final EnemyView enemyView;
	
	
	public EnemyControllerImpl() {
		
		enemy = new EnemyImpl(100,100,3,7);
		enemyView = new EnemyViewImpl();
		this.initEnemyView();
		
		
	}
	@Override
	public void initEnemyView() {
		// TODO Auto-generated method stub
		enemyView.setPosition(enemy.getPosX(), enemy.getPosY());
		enemyView.setWidthHeight(enemy.getHeight(), enemy.getWidth());
		enemyView.setImage(enemy.getImagePath());
		
	}

	@Override
	public void enemyMovement(double n) {
		// TODO Auto-generated method stub
		enemy.setPosX(screenCheck(n));
		enemy.setPosY(screenCheck(n));
		enemyView.updatePosition(screenCheck(n));
		
	}

	@Override
	public EnemyView getEnemyView() {
		// TODO Auto-generated method stub
		return this.enemyView ;
	}

	@Override
	public Entity getEnemyModel() {
		// TODO Auto-generated method stub
		return this.enemy;
	}

	@Override
	public double screenCheck(double x) {
		// TODO Auto-generated method stub
		
			newPosition = enemy.getPosX()+x;
			if((newPosition >= 0)&&(newPosition < SCREEN_WIDTH)){
				return (enemy.getPosX()+x);
			}else
			return enemy.getPosX();
		
	}

}

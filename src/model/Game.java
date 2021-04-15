package model;

import java.util.List;

public interface Game {
	
	void update();
	
	List<Entity> getEntities();
	
	GameStatus getStatus();
	
	void checkCollision();
	
	int getLevel();
	
	int getScore();
	
	PlayerImpl getPlayer();
	
	List<BulletImpl> getBullets();
}

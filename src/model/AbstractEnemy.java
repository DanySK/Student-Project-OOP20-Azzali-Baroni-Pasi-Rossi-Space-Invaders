package model;

import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;
import model.EnemyImpl;
import model.GameImpl;
import model.ID;
import utility.Pair;

public abstract class AbstractEnemy extends EntityImpl implements EnemyBehaviour {
	private static final int WIDTH_X = GameImpl.ARENA_WIDTH;
	private static final int HEIGHT_Y = GameImpl.ARENA_HEIGHT;
	private final Enemy model;
	private final int spd;
	private final int hit; 
	private boolean done;
	
	public AbstractEnemy(final Pair<Integer, Integer> position, final int speedX, final int speedY, final ID id, final int hit) {
		super(position, speedX, speedY, id);
		this.spd = speedX;
		this.hit = hit;
		done = false;
		model = new EnemyImpl(hit);
	}
	
	protected AbstractEnemy createEnememy() {
		double number;
		do {
			number = ThreadLocalRandom.current().nextDouble(0, WIDTH_X);
		} while ((number > WIDTH_X / 3 && number < (WIDTH_X * 2) / 3) || model.tiedupX((int) number));
		model.addNumber(true, (int) number);
		this.getPosition().setY((int) number);
		done = false;
		return this;
	}
	
	protected void deleteList() {
		if (!done) {
			model.deleteList();
			done = true;
		}
	}
	
	protected void setHitbox() {
		setHitbox(new Rectangle(this.getPosition().getX() - (hit / 2 ), this.getPosition().getY() - (hit / 2), hit, hit));
		
	}	
	
	
			
		
		
	}



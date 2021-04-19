package model;

import java.awt.Rectangle;

import utility.Pair;

public class BulletImpl extends EntityImpl implements Bullet {
	
	private final ID owner;
    private static final int BULLETSIZE = 20;
    private static final int WIDTH = GameImpl.ARENA_WIDTH / 40;
    private static final int HEIGHT = GameImpl.ARENA_HEIGHT / 22;
    private static final int SPEED = GameImpl.ARENA_HEIGHT / 50;
    
    public BulletImpl(final Integer x, final Integer y, final ID owner) {
        super(new Pair<Integer, Integer>(x, y), 0, SPEED, ID.PLAYER_BULLET);
        if (owner == ID.PLAYER) {
            setSpeed(getSpeed().getX(), getSpeed().getY() * -1);
        }
        this.owner = owner;
        setHitbox(new Rectangle(this.getPosition().getX() - BULLETSIZE, this.getPosition().getY() - BULLETSIZE, WIDTH, HEIGHT));
    }

	@Override
	public ID getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}

	@Override
	public void update() {
        getPosition().setX(getPosition().getX() + getSpeed().getX());
        getPosition().setY(getPosition().getY() + getSpeed().getY());
        setHitbox(new Rectangle(this.getPosition().getX() - 10, this.getPosition().getY() - 10, BULLETSIZE, BULLETSIZE));
        if (this.getPosition().getY() == GameImpl.ARENA_HEIGHT || this.getPosition().getY() < 0) {
            this.setDead();
        }
	}

	@Override
	public void collide(Entity entity) {
		this.setDead();
		
	}
}

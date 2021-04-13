package model;

import java.util.LinkedList;

import controller.KeyPolling;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class PlayerImpl implements Entity{
	
	public static final int ARENA_LIMIT_LEFT   = 50;
    public static final int ARENA_LIMIT_RIGHT = 854;
    public static final int PLAYER_DEFAULT_SPEED = 5;
    public static final int BULLETS_NUMBER = 15;


	
	Point2D position;
    float scale = 1;
    double width;
    double height;
    Image playerImage;
    
    LinkedList<BulletImpl> bullets = new LinkedList<BulletImpl>();
    BulletImpl bullet = new BulletImpl(new Image(getClass().getResourceAsStream("/Player.png")));
	
    KeyPolling keys = KeyPolling.getInstance();
    
    
    public PlayerImpl(Image playerImage) {
        this.playerImage = playerImage;
        this.width = playerImage.getWidth();
        this.height = playerImage.getHeight();
    }
    
    @Override
	public Point2D getDrawPosition() {
        return position;
    }
    
    @Override
	public void move(Point2D movement) {
        this.position = this.position.add(movement);
    }

    @Override
	public void setDrawPosition(float x, float y) {
        this.position = new Point2D(x, y);
    }

    @Override
	public float getScale() {
        return scale;
    }
    
    @Override
	public Point2D getCenter() {
        Point2D pos = getDrawPosition();
        return new Point2D(pos.getX() + width / 2, pos.getY() + height / 2);
    }
    
    @Override
	public Image getImage() {
        return playerImage;
    }
    
    @Override
	public void setScale(float scale) {
        this.scale = scale;
    }
    
    @Override
	public double getWidth() {
        return this.width * getScale();
    }
    
    @Override
	public double getHeight() {
        return this.height * getScale();
    }
    
	 
    public LinkedList<BulletImpl> getBullets() {
		return bullets;
	}

	@Override
	public void update() {
    }
    
    
    public void shoot() {
    }

	
    public void updatePlayerMovement(float frameDuration) {
        if (keys.isDown(KeyCode.RIGHT)) {
        	if(getCenter().getX() > ARENA_LIMIT_RIGHT) {
        	}
        	else {
                move(new Point2D(PLAYER_DEFAULT_SPEED, 0));
        	}
        }else if (keys.isDown(KeyCode.LEFT)) {
        	if(getCenter().getX() < ARENA_LIMIT_LEFT) {
        	}
        	else {
               move(new Point2D(-PLAYER_DEFAULT_SPEED, 0));
        	}
        } else if(keys.isDown(KeyCode.SPACE)) {
        	shoot();
        } else if(keys.isDown(KeyCode.ESCAPE)) {
        	
        }
        
        //player.update();
    }

}

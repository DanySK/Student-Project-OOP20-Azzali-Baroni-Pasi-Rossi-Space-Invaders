package model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class PlayerImpl implements Entity{
	
	public static final int ARENA_LIMIT_LEFT   = 260;
    public static final int ARENA_LIMIT_RIGHT = 1055;
	
	Point2D position;
    float scale = 1;
    double width;
    double height;
    Image playerImage;
    
    
    public PlayerImpl(Image playerImage) {
        this.playerImage = playerImage;
        this.width = playerImage.getWidth();
        this.height = playerImage.getHeight();
    }
    
     /* **********************************************************
     *                           POSITION                                     *
     ************************************************************ */
    
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
	 
    @Override
	public void update() {
    }
    
    public void shoot() {
    	System.out.println("SPARA");
    }

}

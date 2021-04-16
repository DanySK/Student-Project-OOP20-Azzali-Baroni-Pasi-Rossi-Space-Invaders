package model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class BulletImpl {

	
	/*Point2D position;
    float scale = 1;
    double width;
    double height;
    Image bulletImage;
    
    private Point2D movement = new Point2D(0, -1);
    
    
    public BulletImpl(Image bulletImage) {
        this.bulletImage = bulletImage;
        this.width = bulletImage.getWidth();
        this.height = bulletImage.getHeight();
    }
	
	@Override
	public Point2D getDrawPosition() {
		return position;
	}
	
	@Override
	public void move(Point2D vector) {
		this.position = this.position.add(vector);
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
		 return bulletImage;
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
		move(movement);
	}
	
	public void drawBullet(Canvas c, Point2D pos) {
		c.getGraphicsContext2D().drawImage(bulletImage, pos.getX(), pos.getY());
	}*/

}

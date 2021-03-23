package model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class EnemyImpl implements Entity{
	
	Point2D position;
    float scale = 1;
    double width;
    double height;
    Image enemyImage;
    int space = 25;
    
    private Point2D movement = new Point2D(0.5, 0);
    
    
    public EnemyImpl(Image enemyImage) {
        this.enemyImage = enemyImage;
        this.width = enemyImage.getWidth();
        this.height = enemyImage.getHeight();
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
	
	public void setLevelPosition(float y) {
		this.position = new Point2D(0, y);
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
		 return enemyImage;
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
		if(getCenter().getX() < 900) {
			move(movement);
		}
		else {
			setLevelPosition(space);
			space += space;
		}
	}

}

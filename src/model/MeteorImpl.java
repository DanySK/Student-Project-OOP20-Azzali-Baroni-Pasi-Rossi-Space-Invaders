package model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class MeteorImpl implements Meteor{
	
	public static final int ARENA_LIMIT_LEFT = 260;
	public static final int ARENA_LIMIT_RIGHT = 1055;
	public static final double SPEED = 0.2;
	
	Point2D position;
	float Scale = 1;
	double width;
	double height;
	Image MeteorImage;
	
	public MeteorImpl(Image meteorImage) {
		this.MeteorImage = meteorImage;
		this.width = meteorImage.getWidth();
		this.height = meteorImage.getHeight();
	}
	
	@Override
	public Point2D getDrawPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void setDrawPosition(float x, float y) {
		// TODO Auto-generated method stub
		this.position = new Point2D(x,y);
		
	}

	@Override
	public void move(Point2D vector) {
		// TODO Auto-generated method stub
		this.position = this.position.add(vector);
		
	}

	@Override
	public float getScale() {
		// TODO Auto-generated method stub
		return Scale;
	}

	@Override
	public Point2D getCenter() {
		// TODO Auto-generated method stub
		Point2D pos = getDrawPosition();
		return new Point2D(pos.getX() + width / 2, pos.getY() + height / 2);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return MeteorImage;
	}

	@Override
	public void setScale(float scale) {
		// TODO Auto-generated method stub
		this.Scale = scale;
		
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width * getScale();
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height * getScale();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

package model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public interface Entity {

	Point2D getDrawPosition();

	void setDrawPosition(float x, float y);
	
	void move(Point2D vector);

	float getScale();

	Point2D getCenter();

	Image getImage();

	void setScale(float scale);

	double getWidth();

	double getHeight();

	void update();

}
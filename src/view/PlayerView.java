package view;

import javafx.scene.shape.Rectangle;

public interface PlayerView {

	void setPosition(double x,double y);
	
	//set rectangle size
	void setWidthHeight(int height, int width);
	
	void setImage(String image);
	
	void updatePosition(double x);
	
	Rectangle getPlayer();
}

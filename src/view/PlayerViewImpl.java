package view;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PlayerViewImpl implements PlayerView{
	
	private final Rectangle r;
	
	public PlayerViewImpl() {
		r = new Rectangle();
	}

	@Override
	public void setPosition(double x, double y) {
		r.setX(x);
		r.setY(y);
	}

	@Override
	public void setWidthHeight(int height, int width) {
		// TODO Auto-generated method stub
		r.setHeight(width);
		r.setWidth(width);
		
	}

	@Override
	public void setImage(String image) {
		// TODO Auto-generated method stub
		r.setFill(new ImagePattern(new Image(image)));
	}

	@Override
	public void updatePosition(double x,double y) {
		// TODO Auto-generated method stub
		r.setX(x);
		r.setY(y);
		
	}

	@Override
	public Rectangle getPlayer() {
		// TODO Auto-generated method stub
		return this.r;
	}
	

}

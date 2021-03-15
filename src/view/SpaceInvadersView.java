package view;

import javafx.scene.Node;
import javafx.scene.Scene;

public interface SpaceInvadersView {

	void start();
	
	void setScore(int n);
	
	void addChildren(Node n);
	
	public void movementListener(Scene scene);
	
	double getWidth();
}

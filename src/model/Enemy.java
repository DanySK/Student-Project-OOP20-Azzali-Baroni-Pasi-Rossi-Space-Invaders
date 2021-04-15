package model;

public interface Enemy {
	
	boolean tiedupX(int n);
	
	boolean tiedupY(int n);
	
	void deleteList();
	
	void addNumber(boolean list, int n);

}

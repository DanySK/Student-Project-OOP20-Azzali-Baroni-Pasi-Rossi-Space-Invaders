package model;

import java.util.LinkedList;
import java.util.List;

public class EnemyImpl implements Enemy{
	
	private final List<Integer> listEnemyX;
	private final List<Integer> listEnemyY;
	private final int hit; 
	
	public EnemyImpl(final int hit) {
		this.hit = hit;
		listEnemyX = new LinkedList<>();
		listEnemyY = new LinkedList<>();
	}

	@Override
	public boolean tiedupX(final int n) {
		for (final int x : listEnemyX) {
			if (x == n || (x >= n - hit && x <= n + hit)) {
				return true;
			}
		}
		
		return false;		
	}

	@Override
	public boolean tiedupY(final int n) {
		for (final int x : listEnemyY) {
			if (x == n || (x >= - hit && x <= n + hit)) {}
			return true;
		}
		return false;
	}

	@Override
	public void deleteList() {
		listEnemyX.clear();
		listEnemyY.clear();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNumber(boolean list, int n) {
		if(list) {
			listEnemyX.add(n);
			}
		else {
			listEnemyY.add(n);
		}
		
		
		// TODO Auto-generated method stub
		
	}
	

	}
	
	



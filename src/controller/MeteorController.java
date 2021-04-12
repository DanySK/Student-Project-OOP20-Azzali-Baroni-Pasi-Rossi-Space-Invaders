package controller;

import java.util.ArrayList;
import java.util.List;

import controller.view.ArenaViewController;
import model.Meteor;
import model.MeteorImpl;

public class MeteorController {

	private List<Meteor> meteore;
	
	public MeteorController() {
		this.meteore = new ArrayList<Meteor>();
	}
	
	public void addMeteor(final MeteorImpl meteor) {
		this.meteore.add(meteor);
	}
	
	public MeteorImpl getMeteor() {
		return (MeteorImpl) this.meteore.get(1);
		
		
	}
}

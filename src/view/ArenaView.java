package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;

import model.Entity;
import model.GameStatus;
import utility.Pair;

public class ArenaView extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TITLE ="Game";
	
	private final headUpDisplay playerview;
	private final Background back;
   // private final EntityAnimator entAnimator;
	//private final List<Pair<Entity, Image>> entities;
	private double widthProportion;
	private double heightProportion;
	
	public ArenaView(/*,final Keyinput input*/){
		super();
		this.setLayout(new BorderLayout());
		//settare le entita
		this.back = new Background(TITLE);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.playerview = new playerView();
		this.setPreferredSize(new Dimension(ViewImpl.SCREEN_WIDTH,ViewImpl.SCREEN_HEIGHT));
		this.add(this.playerview,BorderLayout.NORTH);
		//settare il key input
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(back.loadImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	

}

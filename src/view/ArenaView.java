package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import controller.Input;
import model.Entity;
import model.GameImpl;
import model.PlayerImpl;
import utility.Pair;

public class ArenaView extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TITLE ="Game";
	
	private final headUpDisplay playerview;
	private final Background back;
    private final EntityView entityview;
	private final List<Pair<Entity, Image>> EntityGame;
	private double widthProportion;
	private double heightProportion;
	
	public ArenaView(final Input input){
		super();
		this.setLayout(new BorderLayout());
		//settare le entita
	    this.entityview = new EntityView();
		this.back = new Background(TITLE);
		this.EntityGame = Collections.synchronizedList(new LinkedList<>());
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		this.playerview = new playerView();
		this.setPreferredSize(new Dimension(ViewImpl.SCREEN_WIDTH,ViewImpl.SCREEN_HEIGHT));
		this.add(this.playerview,BorderLayout.NORTH);
		this.addKeyListener(input);
		if (!this.hasFocus()) {
            this.requestFocusInWindow();
        }
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(back.loadImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		this.EntityGame.forEach(e->{
			g.drawImage(e.getY(),
					(int) (e.getX().getHitbox().getMinX() * this.widthProportion),
					(int) (e.getX().getHitbox().getMinY() * this.heightProportion),
					(int) (e.getX().getHitbox().getWidth() * this.widthProportion),
					(int) (e.getX().getHitbox().getHeight() * this.heightProportion),this);
		});
	}
	
	public void render(final List<Entity> gameEntity,final int level,final int score) {
		if (!this.hasFocus()) {
            this.requestFocusInWindow();
        }
		this.EntityGame.clear();
		widthProportion = (double) this.getWidth() /(double) GameImpl.ARENA_WIDTH;
		heightProportion = (double) this.getHeight() /(double) GameImpl.ARENA_HEIGHT;
	    gameEntity.stream().filter(e -> e.getHitbox() != null).map(e -> new Pair<>(e, entityview.loadImage(e)))
	         .forEach(p -> this.EntityGame.add(p));
		this.repaint();
		//da controllare
		final PlayerImpl player = (PlayerImpl) gameEntity.get(0);
		playerview.render(player, score, level);
	         
	}
	
	

}

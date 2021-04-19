package view;

import java.util.List;

import javax.swing.JPanel;

import model.PlayerImpl;

public abstract class headUpDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_RGB = 255;
	
	public static final int FONT_P = 25;
	
	public abstract void render(PlayerImpl player, int score, int level);

}

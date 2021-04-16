package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameP extends JPanel {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final View view;
	private final String title;
	private final Background background = new Background(MenuP.TITLE);
	
	public static final Dimension BUTTON_DIMENSION = new Dimension(ViewImpl.SCREEN_WIDTH / 4,ViewImpl.SCREEN_HEIGHT/7);
	
	
	
	public GameP(final View view, String title) {
		super();
		this.view = view;
		this.title = title;
	}



	public void display() {
		this.view.switchWindow(this, this.title);
	}
	
	
	protected JButton prepareButton(final String title,final JPanel panel) {
		final JButton button = new JButton(title);
		button.setMaximumSize(new Dimension(BUTTON_DIMENSION.width,BUTTON_DIMENSION.height));
		//settare font
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setBackground(Color.YELLOW);
		panel.add(button);
		return button;
		
	}
	protected View getView() {
		return this.view;
	}
	@Override
	protected void paintComponent(final Graphics g) {
		g.drawImage(this.background.loadImage(),0 ,0,this.getWidth(),this.getHeight(),this);
	}
}

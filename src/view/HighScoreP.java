package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class HighScoreP extends GameP {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TITLE = "HighScore" ;
	private final JTextPane JtP = new JTextPane();
	//creare lista Scores
	
	public HighScoreP(final View view) {
		super(view,HighScoreP.TITLE);
		//settare array
		JtP.setEditable(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
			final JLabel title = new JLabel("HighScores");
			title.setFont(new Font("Bauhaus 93",Font.BOLD,BUTTON_DIMENSION.height / 3));
			title.setForeground(Color.YELLOW);
			title.setAlignmentX(CENTER_ALIGNMENT);
			this.add(title);
			
		this.add(Box.createVerticalGlue());
		this.add(JtP);
		this.add(Box.createVerticalGlue());
		
		final SimpleAttributeSet att = new SimpleAttributeSet();
		StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
		JtP.setParagraphAttributes(att, true);
		JtP.setMaximumSize(new Dimension(ViewImpl.SCREEN_WIDTH/3, ViewImpl.SCREEN_HEIGHT/3));
		
		JtP.setOpaque(true);
		this.prepareButton("Back", this).addActionListener(e -> {
			this.getView().switchWindow(this,MenuP.TITLE);
		});
		this.add(Box.createHorizontalGlue());
	}

	@Override
	public void display() {
		//settare update hishscore
		this.getView().switchWindow(this, HighScoreP.TITLE);	
		}
	
	private void updateHighScoreP() {
		this.getView().getObserver().update(this, StateV.HIGHSCORES);
		//settare testo tabella
	}
	public void setScores(final List<String> highscores) {
		//implementare con lista da creare
	}

}

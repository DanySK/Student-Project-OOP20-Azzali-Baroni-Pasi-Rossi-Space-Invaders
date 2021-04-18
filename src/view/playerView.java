package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class playerView extends headUpDisplay{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JProgressBar lifeBar;
	private final JTextField score;
	private final JTextField level;
	final JTextField scoretxt = new JTextField(10);
	final JTextField leveltxt = new JTextField(10);
	
	public playerView() {
		super();
		final GroupLayout g = new GroupLayout(this);
		this.setLayout(g);
		this.setOpaque(false);
		this.lifeBar = new JProgressBar(0,50);
		this.lifeBar.setValue(100);
		this.lifeBar.setBackground(Color.BLACK);
		this.lifeBar.setBackground(Color.YELLOW);
		scoretxt.setFont(new Font("Bauhaus 93", 2, ViewImpl.SCREEN_HEIGHT / headUpDisplay.FONT_P));
		leveltxt.setFont(new Font("Bauhaus 93", 2, ViewImpl.SCREEN_HEIGHT / headUpDisplay.FONT_P));
		scoretxt.setEditable(false);
		leveltxt.setEditable(false);
		//si potrebbe mettere un border
		scoretxt.setForeground(Color.WHITE);
		leveltxt.setForeground(Color.WHITE);
		scoretxt.setHorizontalAlignment(SwingConstants.RIGHT);
		leveltxt.setHorizontalAlignment(SwingConstants.RIGHT);
		this.score = scoretxt;
		this.level = leveltxt;
		g.setAutoCreateGaps(true);
		g.setAutoCreateContainerGaps(true);
		
		g.setHorizontalGroup(g.createSequentialGroup()
				.addContainerGap()
				.addComponent(this.lifeBar, 0, GroupLayout.PREFERRED_SIZE,Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
				.addGroup(g.createParallelGroup(Alignment.TRAILING))
				.addComponent(this.score, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
		        .addComponent(this.score, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
		        );
		
		g.setVerticalGroup(g.createSequentialGroup()
				.addGroup(g.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.lifeBar, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addComponent(this.score, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addComponent(this.level, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
				);		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		this.score.setFont(new Font("", 2, this.getParent().getHeight() / headUpDisplay.FONT_P));
	    this.level.setFont(new Font("", 2, this.getParent().getHeight() / headUpDisplay.FONT_P));
	}

	//public abstract void render(){}
}

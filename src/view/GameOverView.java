package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PlayerImpl;

public final class GameOverView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static String TITLE ="GameOver";
	private static final int PROPORTION_M = 15;
	private static final int PROPORTION_T=20;
	private static final int ROWS = 6;
	private static final int COLS = 5;
	private static final int FIRST_BUTTON=12;
	private static final int SECOND_BUTTOn = 4;

    private final Background back = new Background(TITLE);
    private final JButton backToMenu;
    private final JTextField text;
    private final JTextField GAME_OVER;
    
    public GameOverView(PlayerImpl player,final int score,final View view) {
    	super();
    	this.backToMenu = new JButton("Back");
    	this.text = new JTextField("Score: "+ score);
    	this.GAME_OVER = new JTextField("GAME OVER");
    	this.backToMenu.addActionListener(e -> view.resetToMenu());
    	this.backToMenu.setBorder(BorderFactory.createEmptyBorder());
    	 this.backToMenu.setBackground(Color.YELLOW);
         this.backToMenu.setForeground(Color.BLACK);
         this.backToMenu.setOpaque(false);
         this.text.setBorder(BorderFactory.createEmptyBorder());
         this.text.setBackground(Color.YELLOW);
         this.text.setForeground(Color.BLACK);
         this.text.setOpaque(false);
         this.GAME_OVER.setBorder(BorderFactory.createEmptyBorder());
         this.GAME_OVER.setBackground(Color.YELLOW);
         this.GAME_OVER.setForeground(Color.BLACK);
         this.GAME_OVER.setOpaque(false);
         this.setLayout(new GridLayout(ROWS, COLS));
         IntStream.range(0, FIRST_BUTTON).forEach(i -> this.add(Box.createRigidArea(new Dimension(0, 0))));
         this.add(this.text);
         IntStream.range(0, SECOND_BUTTOn).forEach(i -> this.add(Box.createRigidArea(new Dimension(0, 0))));
         this.add(backToMenu);
         IntStream.range(0, FIRST_BUTTON).forEach(i -> this.add(Box.createRigidArea(new Dimension(0, 0))));
         this.repaint();
    }

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
  		this.backToMenu.setFont(new Font("Bauhaus 93",2,this.getHeight() / PROPORTION_M));
        this.text.setFont(new Font("Bauhaus 93", 2, this.getHeight() / PROPORTION_T));
//        this.GAME_OVER.setFont(new Font("Bauhaus 93", 2, this.getHeight() / PROPORTION_T));
        g.drawImage(back.loadImage(),0, 0, this.getWidth(), this.getHeight(), this);
	}


    
    
    
}

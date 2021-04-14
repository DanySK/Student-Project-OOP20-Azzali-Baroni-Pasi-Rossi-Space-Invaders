package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.view.ViewObserver;
import view.MenuP.MenuState;

public class ViewImpl extends JFrame implements View{
	
	
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 6*5;
	
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height /6*5;
	
	private ViewObserver observer;
	private final JPanel main;
	private final CardLayout card = new CardLayout();
	private final List<String> Cards;
	
	
	public ViewImpl() {
		super();
		this.setTitle("Space Invaders");
		this.Cards = new ArrayList<>();
		this.main= new JPanel(card);
		this.main.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(main);
		this.switchWindow(new MenuP(this, MenuState.Start), MenuP.TITLE);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void start() {
		this.setVisible(true);
		
	}

	@Override
	public void draw(List<Entity> list, int score, int level) {
		//final ArenaView
		
	}

	@Override
	public ViewObserver getObserver() {
		// TODO Auto-generated method stub
		return this.observer;
	}

	@Override
	public void switchWindow(JPanel windows, String Title) {
		if(this.Cards.contains(Title) == false) {
			this.Cards.add(Title);
			this.card.addLayoutComponent(windows, Title);
			this.main.add(this.main,Title);
		}
		this.card.show(this.main, Title);
	}

	@Override
	public void resetToMenu() {
		Arrays.stream(this.main.getComponents()).skip(1).forEach(p -> this.main.remove(p));
		this.Cards.removeIf(k -> !k.equals(MenuP.TITLE));
		
	}

	@Override
	public void attach(ViewObserver observer) {
		this.observer = observer;
		
	}

	

}

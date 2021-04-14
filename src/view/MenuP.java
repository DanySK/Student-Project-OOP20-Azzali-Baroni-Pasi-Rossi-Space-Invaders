package view;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuP extends GameP{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final GameP PlayerView;
	//private final GameP ScoreView;
	private final MenuState menuState;
	
	public static final String PAUSE_T="Pause";
	public static final String TITLE = "Start";
	

	public enum MenuState{
		Start,Pause;
	}

	public MenuP(View view, final MenuState menuState) {
		super(view, menuState == MenuState.Start ? MenuP.TITLE : MenuP.PAUSE_T );
		this.menuState = menuState;
		//this.ScoreScreen = new HighScorePanel(view);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(Box.createVerticalGlue());
		
		final JLabel title = new JLabel("SPACE INVADERS");
		title.setForeground(Color.WHITE);
		title.setAlignmentX(CENTER_ALIGNMENT);
		//set font da fare
		this.add(title);
		this.add(Box.createVerticalGlue());
		
		if(this.menuState == MenuState.Pause) {
			this.prepareButton("Return Game",this).addActionListener(e ->{
				this.getView().getObserver().update(this, StateV.RESUME);
				this.getView().switchWindow(this, ArenaView.TITLE);
				this.getView().start();
			});
		}
		this.prepareButton("Play", this).addActionListener(e -> {
			if(this.menuState == MenuState.Pause) {
				this.getView().getObserver().update(this, StateV.ABORT);
			}else {
				//this.PlayerView.display();
			}
		});
		this.prepareButton("Score",this).addActionListener(e ->{
			//this.ScoreView.display();
		});		
		
		this.prepareButton("Help", this).addActionListener(e ->{
			this.helpView();
		});
		this.prepareButton("Exit", this).addActionListener(e -> {
			if(this.menuState == MenuState.Pause) {
				this.getView().getObserver().update(this, StateV.ABORT);
			}
			Runtime.getRuntime().exit(0);
		});
		this.add(Box.createVerticalGlue());
		
		
	}
	private void helpView() {
		JOptionPane.showMessageDialog(this,"Contacts:"
				+ "\nAlberto Rossi"
				+ "\nEnrico Baroni"
				+ "\nMichele Pasi"
				+ "\nRiccardo Azzali");
	}

}

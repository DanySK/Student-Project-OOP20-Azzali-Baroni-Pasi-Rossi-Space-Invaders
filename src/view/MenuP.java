package view;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The Class MenuP.
 */
public class MenuP extends GameP{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Score view. */
	private final GameP ScoreView;
	
	/** The menu state. */
	private final MenuState menuState;
	
	/** The Constant PAUSE_T. */
	public static final String PAUSE_T="Pause";
	
	/** The Constant TITLE. */
	public static final String TITLE = "Start";
	

	/**
	 * The Enum MenuState.
	 */
	public enum MenuState{
		
		/** The Start. */
		Start,
/** The Pause. */
Pause;
	}

	/**
	 * Instantiates a new menu P.
	 *
	 * @param view the view
	 * @param menuState the menu state
	 */
	public MenuP(View view, final MenuState menuState) {
		super(view, menuState == MenuState.Start ? MenuP.TITLE : MenuP.PAUSE_T );
		this.menuState = menuState;
		this.ScoreView = new HighScoreP(view);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(Box.createVerticalGlue());
		
		final JLabel title = new JLabel("SPACE INVADERS");
		title.setForeground(Color.WHITE);
		title.setAlignmentX(CENTER_ALIGNMENT);
		//set font da fare
		
		//this.add(title);
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
				this.getView().getObserver().update(this, StateV.START);
			}
		});
		this.prepareButton("Score",this).addActionListener(e ->{
			this.ScoreView.display();
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
	
	/**
	 * Help view.
	 */
	private void helpView() {
		JOptionPane.showMessageDialog(this,"Commands"
				+ "\nLEFT ARROW KEY = LEFT"
				+ "\nRIGHT ARROW KEY = RIGHT"
				+ "\nSPACE = Shoot"
				+ "\nP = Pause"
				+ "\nContacts:"
				+ "\nAlberto Rossi"
				+ "\nEnrico Baroni"
				+ "\nMichele Pasi"
				+ "\nRiccardo Azzali");
	}

}

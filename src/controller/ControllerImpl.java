package controller;

import game.GameImpl;
import game.GameMode;
import view.GameWindow;
import view.HighScoresPanel;
import view.View;
import view.ViewState;

public class ControllerImpl implements Controller{
	
	private View view;
	private GameLoop gameLoop;
	//private Game game;
	//private final HighscoreManager highscore;
	
	
	public ControllerImpl() {
		//this.highscore = new HighscoreManager();
	}
	
    private void startGame(final GameMode mode) throws IllegalStateException {
        if (this.view == null) {
            throw new IllegalStateException();
        }
        //this.game = new GameImpl(mode);
        //final KeyInput input = new KeyInput(game, this);
        //this.gameLoop = new GameLoop(this.game, this.view, this.highscore, input);
        //this.view.switchWindow(new GameWindow(mode, input), GameWindow.TITLE);
        this.gameLoop.start();
    }
    
    /*public void update(final GamePanel gamePanel, ViewStatus viewStatus) {
        if (viewStatus.equals(ViewStatus.HIGHSCORES) && gamePanel instanceof HighScoresPanel) {
            ((HighScoresPanel) gamePanel).setHighscores(highscore.getHighscores());
        } else if (viewStatus.equals(ViewStatus.RESUME)) {
            this.gameLoop.resume();
        } else if (viewStatus.equals(ViewStatus.ABORT)) {
            this.gameLoop.abort();
        } else if (viewStatus.equals(ViewStatus.START)) {
            this.startGame(GameMode.SINGLEPLAYER);
        } else if (viewStatus.equals(ViewStatus.PAUSE)) {
            this.gameLoop.stop();
        }
    }*/
    
	@Override
	public void setView(View view) {
		this.view = view;
	}
	@Override
	public GameStatus checkGameStatus() {
		//return this.gameLoop.getStatus();
	}

}

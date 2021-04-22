package controller;

import model.Game;
import model.GameImpl;
import model.GameStatus;
import view.ArenaView;
import view.GameP;
import view.HighScoreP;
//import view.HighScoresPanel;
import view.View;
import view.StateV;

public class ControllerImpl implements Controller{
	
	private View view;
	private GameLoop gameLoop;
	private Game game;
	private final ScoreController highscore;
	
	
	public ControllerImpl() {
		this.highscore = new ScoreController();
	}
	//final GameMode mode
    private void startGame() throws IllegalStateException {
        if (this.view == null) {
            throw new IllegalStateException();
        }
        this.game = new GameImpl();
        final Input input = new Input(game, this);
        this.gameLoop = new GameLoop(this.game, this.view,this.highscore,input);
        this.view.switchWindow(new ArenaView(input), ArenaView.TITLE);
        this.gameLoop.start();
    }
    
    public void update(final GameP gamePanel, StateV viewStatus) {
        if (viewStatus.equals(StateV.HIGHSCORES) && gamePanel instanceof HighScoreP) {
            ((HighScoreP) gamePanel).setScores(highscore.getScore());
        } else
    	if (viewStatus.equals(StateV.RESUME)) {
            this.gameLoop.resume();
        } else if (viewStatus.equals(StateV.ABORT)) {
            this.gameLoop.abort();
        } else if (viewStatus.equals(StateV.START)) {
            this.startGame();
        } else if (viewStatus.equals(StateV.PAUSE)) {
            this.gameLoop.stop();
        }
    }
    
	@Override
	public void setView(View view) {
		this.view = view;
	}
	@Override
	public GameStatus checkGameStatus() {
		return this.game.getStatus();
	}


}

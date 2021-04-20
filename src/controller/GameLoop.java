package controller;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import model.Game;
import model.GameStatus;
import view.MenuP;
import view.MenuP.MenuState;
import view.View;



public final class GameLoop implements Runnable{
	
	public static final int FPS = 60;
	private static final double NANOSECONDS_FRAME = 1000000000 / FPS;
	private static final int NANO_MILLISECONDS = 1000000;
	
	private volatile GameLoopStatus gameLoopStatus;
    private final Game game;
    private final View view;
    //private final HighscoreManager highscore;
    private final Input input;
    private final MenuP pauseMenu;
	
    
    public GameLoop(final Game game, final View view /*, final HighscoreManager highscore*/, final Input input) {
        this.game = game;
        this.view = view;
        //this.highscore = highscore;
        this.input = input;
        this.gameLoopStatus = GameLoopStatus.READY;
        this.pauseMenu = new MenuP(view, MenuState.Pause);
    }
	
	
	
	public synchronized void start() {
		final Thread thread;
		thread = new Thread(this);
        if (this.gameLoopStatus.equals(GameLoopStatus.READY)) {
            thread.start();
            this.gameLoopStatus = GameLoopStatus.RUNNING;
        }
	}
	
	public synchronized void stop() {
		this.gameLoopStatus = GameLoopStatus.PAUSED;
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (!this.gameLoopStatus.equals(GameLoopStatus.ENDED)) {
            if (this.gameLoopStatus.equals(GameLoopStatus.PAUSED)) {
                this.view.switchWindow(this.pauseMenu, MenuP.PAUSE_T);
            }
            while (this.gameLoopStatus.equals(GameLoopStatus.PAUSED)) {
                try {
                    Thread.sleep((long) (NANOSECONDS_FRAME / NANO_MILLISECONDS));
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                lastTime = System.nanoTime();
            }
            final long now = System.nanoTime();
            delta += (now - lastTime) / NANOSECONDS_FRAME;
            lastTime = now;
            while (delta >= 1) {
                this.input.update();
                this.game.update();
                this.game.checkCollision();
                delta -= 1;
            }
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        GameLoop.this.view.draw(GameLoop.this.game.getEntities(), GameLoop.this.game.getScore(), GameLoop.this.game.getLevel());
                    }
                });
            } catch (InvocationTargetException | InterruptedException e1) {
                e1.printStackTrace();
            }
            
            if (!this.game.getStatus().equals(GameStatus.RUNNING)) {
                this.gameLoopStatus = GameLoopStatus.ENDED;
            }
            frames++;
            if (lastTime - System.nanoTime() + NANOSECONDS_FRAME > 0) {
                try {
                    Thread.sleep((long) (lastTime - System.nanoTime() + NANOSECONDS_FRAME) / NANO_MILLISECONDS);
                } catch (Exception e) {
                    this.gameLoopStatus = GameLoopStatus.ENDED;
                }
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS:" + frames);
                frames = 0;
            }
        }
            //this.highscore.checkHighscores(game.getScore());
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    //GameLoop.this.view.switchWindow(new EndScreen(GameLoop.this.game.getMode(), 
                            //GameLoop.this.game.getPlayer(), GameLoop.this.game.getScore(), GameLoop.this.view), EndScreen.TITLE);
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	 /**
     * Aborts the gameLoop.
     */
    public void abort() {
        this.gameLoopStatus = GameLoopStatus.ENDED;
    }

    /**
     * Resumes the gameLoop.
     */
    public void resume() {
        this.gameLoopStatus = GameLoopStatus.RUNNING;
    }
	
}

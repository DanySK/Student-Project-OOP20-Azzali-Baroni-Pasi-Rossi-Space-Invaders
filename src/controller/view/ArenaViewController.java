package controller.view;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import controller.GameLoop;
import controller.KeyPolling;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.EnemyImpl;
import model.PlayerImpl;
import view.Renderer;


public class ArenaViewController implements Initializable{
	
	public static final int ARENA_LIMIT_LEFT   = 258;
    public static final int ARENA_LIMIT_RIGHT = 1056;
    public static final int PLAYER_DEFAULT_SPEED = 5;
    public static final int PLAYER_CENTER_X = 415;
    public static final int PLAYER_CENTER_Y = 420;
    public static final float PLAYER__DEFAULT_SCALE = 0.1f;

	
    @FXML
    private AnchorPane arenaPane;
    
    @FXML
    private Canvas gameCanvas;

    KeyPolling keys = KeyPolling.getInstance();

    private PlayerImpl player = new PlayerImpl(new Image(getClass().getResourceAsStream("/Player.png")));
    LinkedList<EnemyImpl> enemies = new LinkedList<EnemyImpl>();

    int spacing = 0;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initialiseCanvas();
        
        player.setDrawPosition(PLAYER_CENTER_X, PLAYER_CENTER_Y);
        player.setScale(PLAYER__DEFAULT_SCALE);
        
        for(int i = 0; i <= 10; i ++) {
        	enemies.add(new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png"))));
        }
        
        for(int i = 0; i <= 10; i ++) {
        	enemies.get(i).setDrawPosition(spacing, 0);
        	enemies.get(i).setScale(0.5f);
        	spacing += 50;
        }

        
        Renderer renderer = new Renderer(this.gameCanvas);
        renderer.addEntity(player);
        
        for(int i = 0; i <= 10; i ++) {
        	renderer.addEntity(enemies.get(i));
        }
        
        
        

        renderer.setBackground(new Image(getClass().getResourceAsStream("/backgroundGame.png")));

        GameLoop timer = new GameLoop() {
            @Override
            public void tick(float secondsSinceLastFrame) {
                renderer.prepare();

                updatePlayerMovement(secondsSinceLastFrame);
                
                for(int i = 0; i <= 10; i ++) {
                	enemies.get(i).update();
                }
                
                renderer.render();
            }
        };
        timer.start();
    }
    
    
    private void initialiseCanvas() {
        gameCanvas.widthProperty().bind(arenaPane.widthProperty());
        gameCanvas.heightProperty().bind(arenaPane.heightProperty());
    }


    private void updatePlayerMovement(float frameDuration) {
        if (keys.isDown(KeyCode.RIGHT)) {
        	if(player.getCenter().getX() > ARENA_LIMIT_RIGHT) {
        	}
        	else {
                player.move(new Point2D(PLAYER_DEFAULT_SPEED, 0));
        	}
        }else if (keys.isDown(KeyCode.LEFT)) {
        	if(player.getCenter().getX() < ARENA_LIMIT_LEFT) {
        	}
        	else {
               player.move(new Point2D(-PLAYER_DEFAULT_SPEED, 0));
        	}
        } else if(keys.isDown(KeyCode.SPACE)) {
        	player.shoot();
        } else if(keys.isDown(KeyCode.ESCAPE)) {
        	
        }
        
        //player.update();
    }
    
}

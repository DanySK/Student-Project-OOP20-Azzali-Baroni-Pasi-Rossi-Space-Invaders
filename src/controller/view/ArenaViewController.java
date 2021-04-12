package controller.view;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import controller.GameLoop;
import controller.KeyPolling;
import controller.MeteorController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.EnemyImpl;
import model.MeteorImpl;
import model.PlayerImpl;
import view.Renderer;


public class ArenaViewController implements Initializable{
	
    public static final int PLAYER_CENTER_X = 415;
    public static final int PLAYER_CENTER_Y = 440;
    public static final float PLAYER__DEFAULT_SCALE = 0.5f;
    
    public static final int ENEMIES_NUMBER = 33;

    @FXML
    private AnchorPane arenaPane;
    
    @FXML
    private Canvas gameCanvas;

    KeyPolling keys = KeyPolling.getInstance();

    private PlayerImpl player = new PlayerImpl(new Image(getClass().getResourceAsStream("/Player.png")));
    LinkedList<EnemyImpl> enemies = new LinkedList<EnemyImpl>(); 
    boolean pause = false;

    int spacing = 0;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initialiseCanvas();
        Renderer renderer = new Renderer(this.gameCanvas);
        
        player.setDrawPosition(PLAYER_CENTER_X, PLAYER_CENTER_Y);
        player.setScale(PLAYER__DEFAULT_SCALE);

        for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
        	enemies.add(new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png"))));
        }
        
        
        for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
        	enemies.get(i).setDrawPosition(spacing, 0);
        	enemies.get(i).setScale(0.2f);
        	spacing += 25;
        }
        
        
        
        renderer.addEntity(player);
        
        for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
        	renderer.addEntity(enemies.get(i));
        }


        
        renderer.setBackground(new Image(getClass().getResourceAsStream("/backgroundGame.png")));

        GameLoop timer = new GameLoop() {
            @Override
            public void tick(float secondsSinceLastFrame) {
                renderer.prepare();

                player.updatePlayerMovement(secondsSinceLastFrame);
                if(pause == false) {
                
                for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
                	enemies.get(i).update();
                }
                
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
    
}

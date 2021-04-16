/*package controller.view;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import controller.GameLoop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import model.EnemyImpl;
import model.PlayerImpl;
import view.Renderer;


public class ArenaViewController implements Initializable{
	
    public static final int PLAYER_CENTER_X = 415;
    public static final int PLAYER_CENTER_Y = 440;
    public static final float PLAYER__DEFAULT_SCALE = 0.5f;
    
    public static final int ENEMIES_NUMBER = 5;

    @FXML
    private AnchorPane arenaPane;
    
    @FXML
    private Canvas gameCanvas;

    //private PlayerImpl player = new PlayerImpl(new Image(getClass().getResourceAsStream("/Player.png")));
    LinkedList<EnemyImpl> enemies = new LinkedList<EnemyImpl>();
    boolean pause = false;

    int spacing = 0;


	@Override
    public void initialize(URL location, ResourceBundle resources) {

        initialiseCanvas();
        
        //player.setDrawPosition(PLAYER_CENTER_X, PLAYER_CENTER_Y);
        //player.setScale(PLAYER__DEFAULT_SCALE);
        
        for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
        	enemies.add(new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png"))));
        }
        
        
        for(int i = 0; i <= ENEMIES_NUMBER; i ++) {
        	//enemies.get(i).setDrawPosition((float) Math.random() * 900, 100);
        	//enemies.get(i).setScale(0.2f);
        }

        Renderer renderer = new Renderer(this.gameCanvas);
        
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
                	//Elimina entità nemiche quando escono dalla schermata
                	if(enemies.get(i).getCenter().getY() > 500) {
                		renderer.removeEntity(enemies.get(i));
                	}
                }
                
                }
                
                renderer.render();
                
            }
        };
        timer.start();
        if (pause==false) {
     	   timer.pause();
     	  
        }
    }
    
    
    private void initialiseCanvas() {
        gameCanvas.widthProperty().bind(arenaPane.widthProperty());
        gameCanvas.heightProperty().bind(arenaPane.heightProperty());
    }
    
}*/

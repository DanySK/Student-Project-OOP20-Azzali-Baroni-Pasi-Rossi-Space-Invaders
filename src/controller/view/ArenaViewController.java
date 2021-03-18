package controller.view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.GameLoop;
import controller.KeyPolling;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.EnemyImpl;
import model.PlayerImpl;
import view.Renderer;

public class ArenaViewController implements Initializable{
	
    @FXML
    private AnchorPane arenaPane;
    
    @FXML
    private Canvas gameCanvas;

    KeyPolling keys = KeyPolling.getInstance();

    private PlayerImpl player = new PlayerImpl(new Image(getClass().getResourceAsStream("/Player.png")));
    private EnemyImpl enemy1 = new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png")));
    private EnemyImpl enemy2 = new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png")));
    private EnemyImpl enemy3 = new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png")));
    private EnemyImpl enemy4 = new EnemyImpl(new Image(getClass().getResourceAsStream("/Enemy1.png")));



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initialiseCanvas();

        player.setDrawPosition(415, 420);
        player.setScale(0.1f);
        
        enemy1.setDrawPosition(0, 0);
        enemy1.setScale(0.4f);
        enemy2.setDrawPosition(50, 0);
        enemy2.setScale(0.4f);
        enemy3.setDrawPosition(100, 0);
        enemy3.setScale(0.4f);
        enemy4.setDrawPosition(150, 0);
        enemy4.setScale(0.4f);
        
        Renderer renderer = new Renderer(this.gameCanvas);
        renderer.addEntity(player);
        renderer.addEntity(enemy1);
        renderer.addEntity(enemy2);
        renderer.addEntity(enemy3);
        renderer.addEntity(enemy4);
        

        renderer.setBackground(new Image(getClass().getResourceAsStream("/backgroundGame.png")));

        GameLoop timer = new GameLoop() {
            @Override
            public void tick(float secondsSinceLastFrame) {
                renderer.prepare();

                updatePlayerMovement(secondsSinceLastFrame);
                enemy1.update();
                enemy2.update();
                enemy3.update();
                enemy4.update();

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
            player.addThrust(20 * frameDuration);
        } else if (keys.isDown(KeyCode.LEFT)) {
            player.addThrust(-20 * frameDuration);
        } else if(keys.isDown(KeyCode.SPACE)) {
        	player.shoot();
        } else if(keys.isDown(KeyCode.ESCAPE)) {
        	
        }
        player.update();
    }
    
}

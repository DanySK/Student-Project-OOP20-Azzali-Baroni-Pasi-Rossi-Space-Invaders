package utility;

import java.awt.Image;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import model.ID;
import model.powerup.PowerUpT;
import view.ArenaView;
import view.MenuP;

public class ImageLoader {

    private static final ImageLoader IMAGE = new ImageLoader();

    private static final int DIMENSION_SPRITE = 192;
    
    private final Map<ID, List<Image>> entityImages = new HashMap<>();

    private final Map<String, List<Image>> backgroundImages = new HashMap<>();
    
    private final Map<Pair<ID, ID>, List<Image>> bulletImages = new HashMap<>();
    
    private final Map<Pair<ID, PowerUpT>, List<Image>> powerUpImages = new HashMap<>();


    private ImageLoader() {}

    public void findImages() {
        URL imgURL = ImageLoader.class.getResource("/BackgroundMenu.jpg");
        this.backgroundImages.put(MenuP.TITLE, loadImage(imgURL));

        imgURL = ImageLoader.class.getResource("/backgroundGame.png");
        this.backgroundImages.put(ArenaView.TITLE, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Player.png");
        this.entityImages.put(ID.PLAYER, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Enemy1.png");
        this.entityImages.put(ID.BASIC_ENEMY, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Enemy2.png");
        this.entityImages.put(ID.BOSS_ENEMY, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/BlueBullet.png");
        this.bulletImages.put(new Pair<>(ID.PLAYER_BULLET, ID.PLAYER), loadImage(imgURL));
        
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.FIRE_BOOST), loadImage(imgURL));
        imgURL = ImageLoader.class.getResource("/powerupRed_star.png");
        
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.FREEZE), loadImage(imgURL));
        imgURL = ImageLoader.class.getResource("/powerupRed_bolt.png");
        
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.HEALTH), loadImage(imgURL));
        imgURL = ImageLoader.class.getResource("/powerupRed_shield.png");
    }

    public static ImageLoader getImageLoader() {
        return ImageLoader.IMAGE;
    }
    
    private List<Image>loadImage(final URL url){
        return Arrays.asList(new ImageIcon(url).getImage());
    }
    
    public Map<String, List<Image>> getBackgroundImages(){
        return backgroundImages;
    }
    
    public Map<ID, List<Image>> getEntityImages() {
        return entityImages;
    }
    
    public Map<Pair<ID, ID>, List<Image>> getBulletImages() {
        return bulletImages;
    }
    
    public Map<Pair<ID, PowerUpT>, List<Image>> getPowerUpImages() {
        return powerUpImages;
    }

    
}
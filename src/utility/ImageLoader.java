package utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.ID;
import model.SpecialEffect.SpecialEffectT;
import model.powerup.PowerUpT;
import view.ArenaView;
import view.GameOverView;
import view.MenuP;

public class ImageLoader {

    private static final ImageLoader IMAGE = new ImageLoader();

    private static final int DIMENSION_SPRITE = 192;
    
    private final Map<ID, List<Image>> entityImages = new HashMap<>();

    private final Map<String, List<Image>> backgroundImages = new HashMap<>();
    
    private final Map<Pair<ID, ID>, List<Image>> bulletImages = new HashMap<>();
    
    private final Map<Pair<ID, PowerUpT>, List<Image>> powerUpImages = new HashMap<>();
    
    private final Map<Pair<ID, PowerUpT>, List<Image>> AnimationsPowerUp = new HashMap<>();
    
    private final Map<Pair<ID, SpecialEffectT>, List<Image>> AnimationsEffect = new HashMap<>();



    private ImageLoader() {}

    public void findImages() {
        URL imgURL = ImageLoader.class.getResource("/BackgroundMenu.jpg");
        this.backgroundImages.put(MenuP.TITLE, loadImage(imgURL));

        imgURL = ImageLoader.class.getResource("/backgroundGame.png");
        this.backgroundImages.put(ArenaView.TITLE, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/BackgroundMenu.jpg");
        this.backgroundImages.put(GameOverView.TITLE, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Player.png");
        this.entityImages.put(ID.PLAYER, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Enemy1.png");
        this.entityImages.put(ID.BASIC_ENEMY, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Enemy2.png");
        this.entityImages.put(ID.BOSS_ENEMY, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/meteorBrown_big1.png");
        this.entityImages.put(ID.METEOR, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/BlueBullet.png");
        this.bulletImages.put(new Pair<>(ID.PLAYER_BULLET, ID.PLAYER), loadImage(imgURL));
        
        this.entityImages.put(ID.ENEMY_BULLET, loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/powerup_FireBoost.png");
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.FIRE_BOOST), loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/powerup_Freeze.png");
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.FREEZE), loadImage(imgURL)); 
        
        imgURL = ImageLoader.class.getResource("/powerup_Health.png");
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.HEALTH), loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/powerup_Shield.png");
        this.powerUpImages.put(new Pair<>(ID.POWER_UP, PowerUpT.SHIELD), loadImage(imgURL));
        
        imgURL = ImageLoader.class.getResource("/bulletSpeedUp.png");
        this.AnimationsPowerUp.put(new Pair<>(ID.POWER_UP, PowerUpT.FIRE_BOOST), loadEffect(imgURL));
        
        imgURL = ImageLoader.class.getResource("/Explosion.png");
        this.AnimationsEffect.put(new Pair<>(ID.EFFECT, SpecialEffectT.EXPLOSION), loadEffect(imgURL));
        
    }

    public static ImageLoader getImageLoader() {
        return ImageLoader.IMAGE;
    }
    
    private List<Image> loadEffect(final URL url){
    	final List<Image> list = new ArrayList<>();
        final int width;
        final int height;
        final int rows;
        final int cols;
        if (url.toString().endsWith("Explosion.png")) {
            width = 100;
            height = 100;
            rows = 8;
            cols = 8;
        } else  {
            width = DIMENSION_SPRITE;
            height = DIMENSION_SPRITE;
            rows = 1;
            cols = 4;
        }
        try {
            final BufferedImage img = ImageIO.read(url);
            IntStream.rangeClosed(0, rows).forEach(i -> IntStream.rangeClosed(0, cols).forEach(j -> {
                list.add(img.getSubimage(j * width, i * height, width, height));
//                System.out.println("Loaded" + i + " " + j);
            }));
        } catch (final IOException e) {
            System.out.println("Error loading Effect");
        }
        return list;
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
    public Map<Pair<ID, PowerUpT>, List<Image>> getAnimationsPowerUp() {
        return AnimationsPowerUp;
    }

    public Map<Pair<ID, SpecialEffectT>, List<Image>> getAnimationsEffect() {
        return AnimationsEffect;
    }
    
}
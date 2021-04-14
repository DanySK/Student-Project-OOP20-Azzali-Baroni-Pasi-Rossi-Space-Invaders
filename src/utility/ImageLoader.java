package utility;

import java.awt.Image;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import view.ArenaView;
import view.MenuP;

public class ImageLoader {

	private static final ImageLoader IMAGE = new ImageLoader();
	
	private static final int DIMENSION_SPRITE=192;
	
	private final Map<String, List<Image>> backgroundImages = new HashMap<>();
	
	private ImageLoader() {}
	
	public void findImages() {
		URL imgURL = ImageLoader.class.getResource("BackgroundGame.jpg");
		this.backgroundImages.put(MenuP.TITLE, loadImage(imgURL));
		
		imgURL = ImageLoader.class.getResource("backgroundGame.png");
		this.backgroundImages.put(ArenaView.TITLE,loadImage(imgURL));
		
		
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
}

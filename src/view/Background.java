package view;

import java.awt.Image;
import java.util.Random;

import utility.ImageLoader;

public class Background {

	private final ImageLoader loader = ImageLoader.getImageLoader();
	private final Image image;
	
	public Background(final String title) {
		final Random random = new Random();
		this.image=loader.getBackgroundImages().get(title).get(random.nextInt(loader.getBackgroundImages().get(title).size()));
		
	}
	public Image loadImage() {
		return image;
	}
}



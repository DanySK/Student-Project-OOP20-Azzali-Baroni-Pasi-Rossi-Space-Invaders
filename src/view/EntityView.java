package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import controller.GameLoop;
import model.Entity;
import model.BulletImpl;
import controller.ChronometerImpl;
import model.powerup.PowerUpImpl;
import model.powerup.PowerUpT;
import utility.Pair;
import utility.ImageLoader;



public class EntityView {
	
	public static final int FRAME_IMAGE = GameLoop.FPS / 20;
	private final ImageLoader loader;
	private final Map<Entity, Integer> currentImage;
	private final Map <Entity, Integer> TimeLastImage;
	private int tick;
	
	public EntityView () {
		this.tick = 0;
		this.loader = ImageLoader.getImageLoader();
		this.currentImage = new HashMap<>();
		this.TimeLastImage = new HashMap<>();
		
		
	}
	

	}



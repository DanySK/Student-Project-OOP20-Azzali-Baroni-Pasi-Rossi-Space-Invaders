package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import controller.GameLoop;
import model.Entity;
import model.SpecialEffect;
import model.Bullet;
import model.BulletImpl;
import controller.ChronometerEntity;
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
	
	public Image loadImage(final Entity e) {
		if (tick > GameLoop.FPS * 10) {
			this.removeUselessEntities();
			this.tick = 0;
			
		}
		switch (e.getID()) {
		case PLAYER_BULLET :
			return loader.getBulletImages().get(new Pair<>(e.getID(), ((Bullet) e).getOwner())).get(0);
		case EFFECT :
			addIfNotPresent(e);
			return getRightImage(e);
		case POWER_UP :
			if(!((PowerUpImpl) e).isActivated()) {
				return loader.getPowerUpImages().get(new Pair <>(e.getID(), ((PowerUpImpl) e).getType())).get(0);
				} else {
					if (((PowerUpImpl) e).getType() != PowerUpT.HEALTH && ((PowerUpImpl) e).getType() != PowerUpT.FIRE_BOOST && ((PowerUpImpl) e).getType() != PowerUpT.FREEZE) {
						addIfNotPresent (e);
						return getRightImage(e);
					}
					return null;
					
				}
			default : 
				return loader.getEntityImages().get(e.getID()).get(0);
			
			
		}
	}
	
	private void removeUselessEntities() {
		final List<Entity> uselessEntities = this.currentImage.keySet().stream().filter(e -> e.isDead()).collect(Collectors.toList());
		uselessEntities.forEach(e -> {
			this.currentImage.remove(e);
			this.TimeLastImage.remove(e);
		});
		
	}

	
	
private Image getRightImage(final Entity entity) {		
	final ChronometerEntity CEntity = (ChronometerEntity) entity;
	final int oTime = TimeLastImage.get(CEntity);
		final int cTime = CEntity.getTimeLeft();
		final List<Image> images = new ArrayList<>();
	switch (entity.getID()) {
		case POWER_UP :
			images.addAll(loader.getAnimationsPowerUp().get(new Pair<>(entity.getID(), ((PowerUpImpl) entity).getType())));
			break;
		case EFFECT :
			images.addAll(loader.getAnimationsEffect().get(new Pair<>(entity.getID(), ((SpecialEffect) entity).getType())));
			break;
			default: System.out.println("Error in getting the right image");
		}
	if (oTime - cTime > FRAME_IMAGE) {
		TimeLastImage.put(CEntity, oTime - FRAME_IMAGE);
		currentImage.put(CEntity, (currentImage.get(CEntity) + 1) % images.size());
	}
	return images.get(currentImage.get(entity));
}
	
	private void addIfNotPresent(final Entity entity) {
		if (!this.currentImage.containsKey(entity)) {
			switch (entity.getID()) {
			case POWER_UP :
				this.TimeLastImage.put(entity, ((PowerUpImpl) entity).getTimeLeft());
				break;
			case EFFECT :
				this.TimeLastImage.put(entity, ((SpecialEffect) entity).getTimeLeft());
				break;
			default : System.out.println("Error in addIfNotPresent");
			}
			this.currentImage.put(entity, 0);
		}
	}
}



package model;

import java.awt.Rectangle;

import controller.ChronometerEntity;
import utility.Pair;
import view.EntityView;

public class SpecialEffect extends ChronometerEntity {
	
	public enum SpecialEffectType {
		
		EXPLOSION (81 * EntityView.FRAME_IMAGE);
		private final int lifetime;
		
		SpecialEffectType(final int lifetime){
			this.lifetime = lifetime;
		}
		
		public int getLifetime() {
			return this.lifetime;
		}
		
	}
	
	private final SpecialEffectType type;
	
	public SpecialEffect(final ID id, final Pair<Integer, Integer> position, final Rectangle hitbox, final SpecialEffectType type) {
		super (position, 0, 0, id, type.getLifetime());
		this.setHitbox(hitbox);
		this.type = type;
	}

	@Override
	public void update() {
		this.tick();
		if(this.isEnded()) {
			this.setDead();
		}
	}
	
	@Override
	public void collide (final Entity entity) {
		
	}
	
	public SpecialEffectType getType() {
		return this.type;
	}
}

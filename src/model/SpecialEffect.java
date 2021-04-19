package model;

import java.awt.Rectangle;

import controller.ChronometerEntity;
import utility.Pair;
import view.EntityView;

public class SpecialEffect extends ChronometerEntity {
	
	public enum SpecialEffectT {
		
		EXPLOSION (81 * EntityView.FRAME_IMAGE);
		private final int lifetime;
		
		SpecialEffectT(final int lifetime){
			this.lifetime = lifetime;
		}
		
		public int getLifetime() {
			return this.lifetime;
		}
		
	}
	
	private final SpecialEffectT type;
	
	public SpecialEffect(final ID id, final Pair<Integer, Integer> position, final Rectangle hitbox, final SpecialEffectT type) {
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
	
	public SpecialEffectT getType() {
		return this.type;
	}
}

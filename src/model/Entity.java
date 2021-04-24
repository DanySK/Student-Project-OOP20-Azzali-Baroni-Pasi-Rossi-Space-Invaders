package model;

import java.awt.Rectangle;

import utility.Pair;

/**
 * The Interface Entity.
 */
public interface Entity {

// Metodo per aggiornare lo status degli oggetti//
	
	/**
 * Update.
 */
void update();
	
// Avvisa qundo un entit� entra in collissione con un altra entit�//
	
	/**
 * Collide.
 *
 * @param entity the entity
 */
void collide(Entity entity);
	
// ritorna l'Hitbox dell'oggetto//
	
	/**
 * Gets the hitbox.
 *
 * @return the hitbox
 */
Rectangle getHitbox();
	
//ritorna se l'entit� � morta//

	/**
 * Checks if is dead.
 *
 * @return true, if is dead
 */
boolean isDead();
	
	//ritorna la velocit� corrente//
	
  /**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	Pair<Integer, Integer> getSpeed();
  
  //Ritorna la poszione dell'oggetto corrente//
  
  /**
   * Gets the position.
   *
   * @return the position
   */
  Pair<Integer, Integer> getPosition();
  
  //ritorna l'ID dell'oggetto//
 
  /**
   * Gets the id.
   *
   * @return the id
   */
  ID getID(); 
  
  // Setta l'Hitbox dell'oggetto//
  
  /**
   * Sets the hitbox.
   *
   * @param hitbox the new hitbox
   */
  void setHitbox(Rectangle hitbox);
  
  // Setta un oggetto come morto//
  
  /**
   * Sets the dead.
   */
  void setDead();
  
  //Setta la posizione dell'oggetto//
  
  /**
   * Sets the position.
   *
   * @param position the position
   */
  void setPosition(Pair<Integer, Integer> position);
  
}


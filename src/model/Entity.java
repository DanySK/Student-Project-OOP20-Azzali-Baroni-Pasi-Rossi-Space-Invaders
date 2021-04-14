package model;

import java.awt.Rectangle;

import utility.Pair;

// Interfaccia per gli oggetti del gioco//

public interface Entity {

// Metodo per aggiornare lo status degli oggetti//
	
	void update();
	
// Avvisa qundo un entit� entra in collissione con un altra entit�//
	
	void collide(Entity entity);
	
// ritorna l'Hitbox dell'oggetto//
	
	Rectangle getHitbox();
	
//ritorna se l'entit� � morta//

	boolean isDead();
	
	//ritorna la velocit� corrente//
	
  Pair<Integer, Integer> getSpeed();
  
  //Ritorna la poszione dell'oggetto corrente//
  
  Pair<Integer, Integer> getPosition();
  
  //ritorna l'ID dell'oggetto//
 
  ID getID(); 
  
  // Setta l'Hitbox dell'oggetto//
  
  void serHitbox(Rectangle hitbox);
  
  // Setta un oggetto come morto//
  
  void setDead();
  
  //Setta la posizione dell'oggetto//
  
  void setPosition(Pair<Integer, Integer> position);
  
}


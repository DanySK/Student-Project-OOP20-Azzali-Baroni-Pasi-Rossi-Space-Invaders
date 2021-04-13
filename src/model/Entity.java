package model;

import java.awt.Rectangle;

import utility.Pair;

// Interfaccia per gli oggetti del gioco//

public interface Entity {

// Metodo per aggiornare lo status degli oggetti//
	
	void update();
	
// Avvisa qundo un entità entra in collissione con un altra entità//
	
	void collide(Entity entity);
	
// ritorna l'Hitbox dell'oggetto//
	
	Rectangle getHitbox();
	
//ritorna se l'entità è morta//

	boolean isDead();
	
	//ritorna la velocità corrente//
	
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


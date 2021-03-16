package controller;

import model.Entity;
import view.EnemyView;

public interface EnemyController {void initEnemyView();

void enemyMovement(double n);

//boolean collision(Rectangle r);

EnemyView getEnemyView();

Entity getEnemyModel();

double screenCheck(double x);

}

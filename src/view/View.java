package view;

import java.util.List;

import javax.swing.JPanel;

import controller.view.ViewObserver;
import model.Entity;

public interface View {

void start();


void draw(List<Entity>list, int score,int level);

ViewObserver getObserver();

void switchWindow(JPanel windows, String Title);

void resetToMenu();

void attach(ViewObserver observer);
}

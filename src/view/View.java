package view;

import javax.swing.JPanel;

import controller.view.ViewObserver;

public interface View {

void start();


void draw(List<Entity>list, int score,int level);

ViewObserver getObserver();

void switchWindow(JPanel windows, String Title);

void resetToMenu();

void attach(ViewObserver observer);
}

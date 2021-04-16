package application;
	
import javax.swing.SwingUtilities;

import controller.Controller;
import controller.ControllerImpl;
import view.View;
import view.ViewImpl;



public class Main {
	
	
	public void main(final String[] args) {
		//ImageLoader.getLoader().findImages();
		//FontLoader.loadFont();
		final Controller controller = new ControllerImpl();
		final View view = new ViewImpl();
		view.attach(controller);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				view.start();
				
			}
			
		});
		
	}

	
}

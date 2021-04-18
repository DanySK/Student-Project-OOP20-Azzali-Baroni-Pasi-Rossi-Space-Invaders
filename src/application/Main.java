package application;
	
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import controller.Controller;
import controller.ControllerImpl;
import utility.ImageLoader;
import view.View;
import view.ViewImpl;



public class Main {
	
	public static void main(final String[] args) {
		ImageLoader.getImageLoader().findImages();
		//FontLoader.FontLoad();
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

package application;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import controller.Controller;
import controller.ControllerImpl;
import utility.ImageLoader;
import view.View;
import view.ViewImpl;



public class Main {
	public static void main(final String[] args) {
		ImageLoader.getImageLoader().findImages();
		final Controller controller = new ControllerImpl();
		final View view = new ViewImpl();
		controller.setView(view);
		view.attach(controller);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				view.start();
				playMusic();
			}
		});
	}

	public static void playMusic() {
		AudioInputStream audioIn;
		Clip clip;
		try {
			audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("/music.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}

}

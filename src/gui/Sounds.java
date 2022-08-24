package gui;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sounds {
	private static Clip menuSong = getClip(new File("assets/sounds/Hungry Cat Theme.wav"));
	private static float volume = 0.3f;
	
	public static void mouseCatched() {
		Clip click = getClip(new File("assets/sounds/cat_meow.wav"));
	    FloatControl gainControl1 = (FloatControl) click.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl1.setValue(20f * (float) Math.log10(volume));
		click.start();
	}
	
	public static void catCatched() {
		Clip click = getClip(new File("assets/sounds/cat_screech.wav"));
	    FloatControl gainControl1 = (FloatControl) click.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl1.setValue(20f * (float) Math.log10(volume));
		click.start();
	}
	
	public static void backgroundSong() {
		menuSong.start();
		menuSong.loop(Clip.LOOP_CONTINUOUSLY);
		FloatControl gainControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl.setValue(20f * (float) Math.log10(volume));
	}
	
	public static Clip getClip(File wavFile) {
		try {
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(wavFile));
		    return clip;
		} catch (Exception e1) {
		    System.out.println(e1);
		}
		return null;
	}
}

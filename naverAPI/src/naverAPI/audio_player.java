package naverAPI;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class audio_player {

	public static void main(String[] args) throws Exception{
		while(true) { 
		
		File a = new File("sample2.wav");
		AudioInputStream b = AudioSystem.getAudioInputStream(a); 
		Clip c = AudioSystem.getClip(); 
		c.open(b); 
		c.start(); 
		Thread.sleep(c.getMicrosecondLength()/1000); }

	}

}

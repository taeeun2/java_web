package naverAPI;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;

public class RecorderTest {
	   
	    public void microphoneTest() throws Exception{
	        Recorder mr = new Recorder(new AudioFormat(16000,16,1, true, false));
	        mr.start();
	        Thread.sleep(5 * 1000);
	        mr.stop();
	        Thread.sleep(1000);

//	        //save
//	        WaveData wd = new WaveData();
//	        Thread.sleep(3000);
//	        wd.saveToFile("~tmp", AudioFileFormat.Type.WAVE, mr.getAudioInputStream());
	        File file = new File("test.wav");
	        AudioSystem.write(mr.getAudioInputStream(), AudioFileFormat.Type.WAVE,file);
	    }
}

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MusicStuff {

	public static void main(String[] args) {
		Thread1 t1= new Thread1();
		Thread2 t2=new Thread2();
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();

		
	}
	
}

class Thread1 extends Thread{
	String[] files={"do.wav","mi.wav","sol.wav","si.wav","do-octave.wav"};
	String name="C:\\Users\\kyley\\eclipse-workspace\\SEG2105A4\\src\\";
	FilePlayer f=new FilePlayer();
	public void run() {
		for (int i=0;i<5;i++) {
			f.play(name+files[i]);
			try {
				Thread.sleep(1300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class Thread2 extends Thread{
	String[] files={"re.wav","fa.wav","la.wav","do-octave.wav"};
	String name="C:\\Users\\kyley\\eclipse-workspace\\SEG2105A4\\src\\";
	FilePlayer g=new FilePlayer();
	public void run() {
		for (int i=0;i<3;i++) {
			g.play(name+files[i]);
			try {
				Thread.sleep(1300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		g.play(name+files[3]);

	}
	
}


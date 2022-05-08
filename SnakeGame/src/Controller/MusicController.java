/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author JIK
 */
public class MusicController{
    AudioInputStream audioStream;
    public boolean condition = true;
    Clip clip;
    File file;
    
    public void stopMusic(){
        clip.stop();
    }
    
    public void backgroundMusic(){
        if(condition){
            try{
                file = new File("Titanic.wav");
                audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void eatAppleMusic(){
        if(condition){
            try{
                file = new File("eatApple.wav");
                audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    //=============================================================//
    private static class SingleTonHolder{
		private static final MusicController instance = new MusicController();
	}
    public static MusicController getInstance() {
            return SingleTonHolder.instance;
    }
    //=============================================================//
}

import greenfoot.*;
/**
 * Write a description of class MusicPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicPlayer  
{
    // instance variables - replace the example below with your own
    public static GreenfootSound music = new GreenfootSound("bgm.mp3");
    public static boolean isPlaying = false;

    /**
     * Constructor for objects of class MusicPlayer
     */
    
    public static void playLoop() {
        if (!isPlaying) {
            music.setVolume(70); 
            music.playLoop();
            isPlaying = true;
        }
    }

    public static void stop() {
        if (isPlaying) {
            music.stop();
            isPlaying = false;
        }
    }
}




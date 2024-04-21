package utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundManager {
    private static SoundManager instance;
    private MediaPlayer mediaPlayer;

    private SoundManager() {
        String soundFile = "res/backgroundMusic.mp3";
        Media sound = new Media(new File(soundFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.1);

    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void play() {
        mediaPlayer.play();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void changeSound(String newSoundFile) {
        stop();

        Media newSound = new Media(new File(newSoundFile).toURI().toString());
        mediaPlayer = new MediaPlayer(newSound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        play();
    }
}

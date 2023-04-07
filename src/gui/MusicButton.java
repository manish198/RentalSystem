package gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicButton {

    public void callButtonMusic()
    {
        MediaPlayer mediaPlayer;
        Media musicplay = new Media("@../../Music/cb.mp3");

       mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

    }

}

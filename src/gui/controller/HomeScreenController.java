package gui.controller;

import gui.constants.Constant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import gui.utils.SwitchScene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class HomeScreenController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");



    @FXML
    public void onPropertyButtonClicked(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.PROPERTY_SCREEN, event);
    }

    @FXML
    public void onTenantButtonClicked(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.TENANT_SCREEN, event);
    }

    @FXML
    public void onLeasesButtonClicked(ActionEvent event) throws IOException{
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.LEASE_SCREEN,event);
    }



}

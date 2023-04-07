package gui.controller;

import gui.constants.Constant;
import gui.controller.property.DisplayPropertyController;
import gui.controller.tenant.DisplayTenantController;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class TenantScreenController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");


    @FXML
    public void onAddTenantButton(ActionEvent event) throws IOException{
        mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.ADD_TENANT,event);
    }
    @FXML
    public void onHomeClick(ActionEvent event) throws IOException {
        mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.HOME_SCREEN,event);
    }
    public void onDisplayTenantButton(ActionEvent event) throws IOException {
        mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.DISPLAY_TENANT));
        root = loader.load();

        DisplayTenantController displayTenantController = loader.getController();

        displayTenantController.showProperties(Constant.api.displayTenants());

//        To switch screen using root whenever something has changed in view
        screenSwitch(root, event);
    }
    public void onDisplayRentStatusButton(ActionEvent event) throws IOException {
        mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.RENT_STATUS,event);
    }
    public void onDisplayPayRentButton(ActionEvent event) throws IOException {
        mediaPlayer = new MediaPlayer(musicplay);
        mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.PAY_RENT,event);
    }



}

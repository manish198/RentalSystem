package gui.controller.tenant;

import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class CheckRentStatusController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");




    @FXML
    public void onHomeClicked(ActionEvent actionEvent) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, actionEvent);
    }
    public void checkRentPaid(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.RENT_STATUS_notpaid));
        root = loader.load();

        CheckRentStatusNotPaidController checkRentStatusNotPaidController = loader.getController();

        checkRentStatusNotPaidController.showProperties(Constant.api.rentPaidStatus());

//        To switch screen using root whenever something has changed in view
        screenSwitch(root, event);
    }
    public void checkRentNotPaid(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.RENT_STATUS_paid));
        root = loader.load();

        CheckRentStatusPaidController checkRentStatusPaidController = loader.getController();

        checkRentStatusPaidController.showProperties(Constant.api.rentNotPaidStatus());

//        To switch screen using root whenever something has changed in view
        screenSwitch(root, event);
    }


}

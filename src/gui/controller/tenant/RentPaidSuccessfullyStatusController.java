package gui.controller.tenant;

import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
public class RentPaidSuccessfullyStatusController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");

    @FXML
    public void onHomeClicked(ActionEvent actionEvent) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, actionEvent);
    }

}

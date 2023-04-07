package gui.controller.property;

import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MakePropertyAvailableController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");



    @FXML
    TextField propertyID;
    @FXML
    Label resLabel;

    @FXML
    public void submit(ActionEvent event) throws InterruptedException, IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        String res = Constant.api.makePropertyAvailable(propertyID.getText());
        resLabel.setText(res);
        if(res.equals("Property is now available")){
            propertyID.setText("");
        }
    }

    @FXML
    public void onHomeClicked(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, event);
    }
}

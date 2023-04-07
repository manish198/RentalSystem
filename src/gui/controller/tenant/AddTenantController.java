package gui.controller.tenant;

import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.IOException;

public class AddTenantController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");


    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField ageField;
    @FXML private TextField emailField;
    @FXML private Label resLabel;

    @FXML
    public void onAddTenantButton(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        this.mediaPlayer = new MediaPlayer(musicplay);
       this.mediaPlayer.setAutoPlay(true);

        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        int age = Integer.parseInt(ageField.getText().trim());
        String email = emailField.getText().trim();
        String res = Constant.api.addTenant(firstName+" "+lastName,age,email);
        System.out.println(res);
        resLabel.setText(res);
    }
    @FXML
    public void onHomeClicked(ActionEvent action) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.HOME_SCREEN,action);
    }

}

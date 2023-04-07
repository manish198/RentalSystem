package gui.controller.tenant;

import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class PayRentController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");


    @FXML private TextField TenantID;
    @FXML private Label resLabel;
    @FXML private Label resLabel1;
    @FXML
    public void onHomeClicked(ActionEvent actionEvent) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, actionEvent);
    }
    @FXML
    public void onPayRentButton(ActionEvent event) throws IOException{
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        String Tenant_ID = TenantID.getText().trim();
        String res= Constant.api.PayRent(Tenant_ID);
        System.out.println(res);
        if(res.equals("Tenant Not Found"))
        {
            resLabel.setText("Tenant Not found");
            resLabel1.setText("Please Re-enter Tenant ID");
        }
        else {
            screenSwitch(Constant.RENT_PAID_SUCCESSFULLY_STATUS, event);
        }


      //  onPayRentButton1(event);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.HOME_SCREEN));
//        root = loader.load();
//        screenSwitch(root,event);

    }
    public void onPayRentButton1(ActionEvent event) throws IOException{
        screenSwitch(Constant.HOME_SCREEN, event);
    }
}

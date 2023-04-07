package gui.controller;

import gui.config.Config;
import gui.constants.Constant;
import gui.controller.property.DisplayPropertyController;
import gui.controller.property.DisplayRentedUnitsController;
import gui.controller.property.DisplayVacantUnitsController;
import gui.utils.SwitchScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyScreenController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");


//    @FXML
    public void onHomeClick(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, event);
    }
    public void onAddPropertyButton(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.ADD_PROPERTY, event);
    }
    public void onDisplayPropertyButton(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    executeOnDisplayPropertyButton(event);
                } catch (IOException e) {
                    System.out.println("Exception occured");
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        System.out.println("I am here");
        thread.start();
    }
    public void executeOnDisplayPropertyButton(ActionEvent event) throws IOException {
        System.out.println("Hello");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.DISPLAY_PROPERTY));
        root = loader.load();

        DisplayPropertyController displayPropertyController = loader.getController();

        displayPropertyController.showProperties(Constant.api.getAllProperties());

//      To switch screen using root whenever something has changed in view
        Platform.runLater(() -> {
            // GUI-related code here
            try {
                screenSwitch(root, event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void onDisplayRentedUnitsButton(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.DISPLAY_RENTED_UNITS));
        root = loader.load();

        DisplayRentedUnitsController displayRentedUnitsController = loader.getController();
        displayRentedUnitsController.showRentedUnits(Constant.api.getAllRentedUnits());

        screenSwitch(root, event);
    }
    public void onDisplayVacantUnitsButton(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constant.DISPLAY_VACANT_UNITS));
        root = loader.load();

        DisplayVacantUnitsController displayVacantUnitsController = loader.getController();
        displayVacantUnitsController.showVacantUnits(Constant.api.getAllVacantUnits());

        screenSwitch(root, event);
    }
    public void onMakePropertyAvailableButton(ActionEvent event) throws IOException {
       this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);

        screenSwitch(Constant.MAKE_PROPERTY_AVAILABLE, event);
    }
}

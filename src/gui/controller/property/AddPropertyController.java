package gui.controller.property;

import gui.MusicButton;
import gui.constants.Constant;
import gui.utils.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.request_model.ApartmentRequest;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AddPropertyController extends SwitchScene {
    MediaPlayer mediaPlayer;
    Media musicplay = new Media("File:///C:/Users/yashb/IdeaProjects/RentalSystem/src/Music/cb.mp3");




    String type;
    int totalUnits = 0;
    ArrayList<model.request_model.ApartmentRequest> apartmentList = new ArrayList();
//    String type = "APARTMENT";
    @FXML
    TextField unitNumber;
    @FXML
    TextField postalCode;
    @FXML
    TextField city;
    @FXML
    TextField province;
    @FXML
    TextField propertyID;
    @FXML
    TextField streetName;
    @FXML
    TextField streetNumber;
    @FXML
    TextField squareFoot;
    @FXML
    TextField numberOfBedrooms;
    @FXML
    TextField numberOfBathrooms;
    @FXML
    Label resLabel;
    @FXML
    TextField numberOfUnits;
    @FXML
    Button onNumberOfUnitsButton;
    @FXML
    Button addUnit;
    @FXML
    TextField civicAddress;
    @FXML
    Label apartmentCounter;
    @FXML
    Button submitButton;
    @FXML
    TextField aptPropertyID;
    @FXML
    TextField aptNumber;
    @FXML
    TextField aptBedrooms;
    @FXML
    TextField aptBathrooms;
    @FXML
    TextField aptSquareFoot;

    @FXML
    public void onHomeClicked(ActionEvent event) throws IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        screenSwitch(Constant.HOME_SCREEN, event);
    }
    public void onHouseCheckClicked() {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        unitNumber.setVisible(false);
        propertyID.setVisible(true);
        streetName.setVisible(true);
        streetNumber.setVisible(true);
        numberOfBathrooms.setVisible(true);
        numberOfBedrooms.setVisible(true);
        squareFoot.setVisible(true);
        numberOfUnits.setVisible(false);
        onNumberOfUnitsButton.setVisible(false);
        addUnit.setVisible(false);
        civicAddress.setVisible(false);
        submitButton.setVisible(true);
        aptPropertyID.setVisible(false);
        aptNumber.setVisible(false);
        aptBedrooms.setVisible(false);
        aptBathrooms.setVisible(false);
        aptSquareFoot.setVisible(false);
        type = "HOUSE";
    }
    public void onApartmentCheckClicked() {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        unitNumber.setVisible(false);
        propertyID.setVisible(false);
        streetName.setVisible(false);
        streetNumber.setVisible(false);
        numberOfBathrooms.setVisible(false);
        numberOfBedrooms.setVisible(false);
        squareFoot.setVisible(false);
        numberOfUnits.setVisible(true);
        onNumberOfUnitsButton.setVisible(true);
        addUnit.setVisible(false);
        civicAddress.setVisible(false);
        submitButton.setVisible(false);

        type = "APARTMENT";
    }
    public void onCondoCheckClicked() {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);
        unitNumber.setVisible(true);
        propertyID.setVisible(true);
        streetName.setVisible(true);
        streetNumber.setVisible(true);
        numberOfBathrooms.setVisible(true);
        numberOfBedrooms.setVisible(true);
        squareFoot.setVisible(true);
        numberOfUnits.setVisible(false);
        onNumberOfUnitsButton.setVisible(false);
        addUnit.setVisible(false);
        civicAddress.setVisible(false);
        submitButton.setVisible(true);
        aptPropertyID.setVisible(false);
        aptNumber.setVisible(false);
        aptBedrooms.setVisible(false);
        aptBathrooms.setVisible(false);
        aptSquareFoot.setVisible(false);
        type = "CONDO";
    }
    public void onNumberOfUnitsClicked(){
        totalUnits = Integer.parseInt(numberOfUnits.getText());
        onNumberOfUnitsButton.setVisible(false);
        addUnit.setVisible(true);
        aptPropertyID.setVisible(true);
        aptNumber.setVisible(true);
        aptBedrooms.setVisible(true);
        aptBathrooms.setVisible(true);
        aptSquareFoot.setVisible(true);
        civicAddress.setVisible(true);
        apartmentCounter.setText("Units left to add: " + totalUnits);
    }
    public void onAddUnitClicked(ActionEvent event){
        apartmentList.add(new ApartmentRequest(aptPropertyID.getText(), Integer.parseInt(aptNumber.getText()), Double.parseDouble(aptSquareFoot.getText()),
                Integer.parseInt(aptBedrooms.getText()), Integer.parseInt(aptBathrooms.getText())));
        totalUnits--;
        aptPropertyID.setText("");
        aptNumber.setText("");
        aptBedrooms.setText("");
        aptBathrooms.setText("");
        aptSquareFoot.setText("");
        apartmentCounter.setText("Units left to add: " + totalUnits);
        if(totalUnits == 0){
            addUnit.setVisible(false);
            submitButton.setVisible(true);
        }
    }

    public void submit(ActionEvent event) throws InterruptedException, IOException {
        this.mediaPlayer = new MediaPlayer(musicplay);
        this.mediaPlayer.setAutoPlay(true);

        String res = "";
        if(type.equals("HOUSE")){
            res = Constant.api.addHouse(type, propertyID.getText(), streetName.getText(), Integer.parseInt(streetNumber.getText()),
                    city.getText(), postalCode.getText(), province.getText(),
                    Integer.parseInt(numberOfBedrooms.getText()), Integer.parseInt(numberOfBathrooms.getText()),
                    Integer.parseInt(squareFoot.getText()));
        }
        else if(type.equals("APARTMENT")){
            res = Constant.api.addApartment(type, civicAddress.getText(), city.getText(), postalCode.getText(),
                    province.getText(), apartmentList);
        }
        else if(type.equals("CONDO")){
            res = Constant.api.addCondo(type, propertyID.getText(), streetName.getText(), Integer.parseInt(streetNumber.getText()),
             city.getText(), postalCode.getText(), province.getText(), Integer.parseInt(unitNumber.getText()),
                    Integer.parseInt(numberOfBedrooms.getText()), Integer.parseInt(numberOfBathrooms.getText()),
                    Integer.parseInt(squareFoot.getText()));
        }
//        System.out.println(res);
        resLabel.setText(res);
        if(res.equals("Property added successfully")){
            type = "";
            propertyID.setText("");
            streetName.setText("");
            streetNumber.setText("");
            city.setText("");
            postalCode.setText("");
            province.setText("");
            unitNumber.setText("");
            numberOfBedrooms.setText("");
            numberOfBathrooms.setText("");
            squareFoot.setText("");
        }
    }
}

package service;

import model.request_model.ApartmentRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RentalServicesTest {
    RentalServices r1=new RentalServices();
    ArrayList<ApartmentRequest> add=new ArrayList<>();
    ApartmentRequest App1=new ApartmentRequest("01",201,12.0,2,3);
    ApartmentRequest App2=new ApartmentRequest("01",202,12.0,2,3);

    String streetName="xyz";
    int streetNumber=1009;
    String postalCode = "H4P2B2";
    String province = "Quebec";
    String city="Montreal";
    String civicaddress="abc";
    String propertyID="01";
    double squareFoot=12.0;
    int numberOfBedRooms=2;
    int numberOfBathRoom=1;
    String Propertytype="CONDO";
    int apartementno=202;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProperty() {
        add.add(App1);
        add.add(App2);
        //String propertyID,String propertyType, String postalCode, String cityName,
        //                              String province, String civicAddress, String streetName, int streetNumber,
        //                              int apartmentNumber, double squareFoot, int numberOfBedRooms,
        //                              int numberOfBathRooms, ArrayList<ApartmentRequest> apartmentList
        assertEquals("Property Added Successfully",r1.addProperty(propertyID,Propertytype,postalCode,city,province,civicaddress,streetName,streetNumber,apartementno,squareFoot,numberOfBedRooms,numberOfBathRoom,add));
    }


}
package model.property.concrete_property;

import model.address.Address;
import model.lease.Lease;
import model.property.property_details.PropertyDetails;
import model.request_model.ApartmentRequest;
import model.tenant.Tenant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentBuildingTest {
    ArrayList<ApartmentRequest> add=new ArrayList<>();
    private HashMap<Integer, PropertyDetails> apartments = new HashMap<Integer, PropertyDetails>();



    String postalCode = "H4P2B2";
    String province = "Quebec";
    String city="Montreal";
    String civicaddress="abc";
    String propertyID="01";
    double squareFoot=12.0;
    int numberOfBedRooms=2;
    int numberOfBathRoom=1;
    boolean isOccupied = false;
    Lease lease=null;

    ArrayList<Tenant> subscribersList=new ArrayList<>();
    //String propertyID,double squareFoot, int numberOfBedRooms, int numberOfBathRooms, boolean isOccupied, Lease lease


    Address address=new Address(postalCode,province,city);
    String streetName;
    int streetNumber;
    int unitNumber;
    //PropertyDetails propertyDetails=new PropertyDetails(propertyID,squareFoot,numberOfBedRooms,numberOfBathRoom);

    //Address address, String streetName, int streetNumber, int unitNumber, PropertyDetails propertyDetails
   // Condo condo=new Condo(address,streetName,streetNumber,unitNumber,propertyDetails);

    ApartmentBuilding ap=new ApartmentBuilding(address,civicaddress,add);
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPropertyType() {
        assertEquals("APARTMENT",ap.getPropertyType());
    }

    @Test
    void getAddress() {
        assertEquals(address,ap.getAddress());
    }

    @Test
    void getCivicAddress() {
        assertEquals(civicaddress,ap.getCivicAddress());
    }




    @Test
    void addProperty() {
    }

    @Test
    void displayProperty() {
        ApartmentRequest App1=new ApartmentRequest("01",201,12.0,2,3);
        ApartmentRequest App2=new ApartmentRequest("01",202,12.0,2,3);

        add.add(App1);
        add.add(App2);
        ApartmentBuilding ap1=new ApartmentBuilding(address,civicaddress,add);
        HashMap<Integer, PropertyDetails> apartments = new HashMap<Integer, PropertyDetails>();
        PropertyDetails propertyDetails=new PropertyDetails("01",12.0,2,3);
        PropertyDetails propertyDetails1=new PropertyDetails("02",12.0,2,3);

        apartments.put(201,propertyDetails);
        apartments.put(202,propertyDetails1);
        assertEquals(false,ap1.displayProperty());
    }

    @Test
    void displayVacantProperty() {
        ApartmentRequest App1=new ApartmentRequest("01",201,12.0,2,3);
        ApartmentRequest App2=new ApartmentRequest("01",202,12.0,2,3);

        add.add(App1);
        add.add(App2);
        ApartmentBuilding ap1=new ApartmentBuilding(address,civicaddress,add);
        HashMap<Integer, PropertyDetails> apartments = new HashMap<Integer, PropertyDetails>();
        PropertyDetails propertyDetails=new PropertyDetails("01",12.0,2,3);
        PropertyDetails propertyDetails1=new PropertyDetails("02",12.0,2,3);

        apartments.put(201,propertyDetails);
        apartments.put(202,propertyDetails1);
        assertEquals(false,ap1.displayVacantProperty());
    }

    @Test
    void displayRentedProperty() {
        ApartmentRequest App1=new ApartmentRequest("01",201,12.0,2,3);
        ApartmentRequest App2=new ApartmentRequest("01",202,12.0,2,3);

        add.add(App1);
        add.add(App2);
        ApartmentBuilding ap1=new ApartmentBuilding(address,civicaddress,add);
        HashMap<Integer, PropertyDetails> apartments = new HashMap<Integer, PropertyDetails>();
        PropertyDetails propertyDetails=new PropertyDetails("01",12.0,2,3);
        PropertyDetails propertyDetails1=new PropertyDetails("02",12.0,2,3);

        apartments.put(201,propertyDetails);
        apartments.put(202,propertyDetails1);
        assertEquals(false,ap1.displayRentedProperty());
    }
}
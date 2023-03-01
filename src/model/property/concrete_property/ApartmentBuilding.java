package model.property.concrete_property;

import model.address.Address;
import model.property.Property;

import java.util.HashMap;

public class ApartmentBuilding extends Property {
    private Address address;
    private String civicAddress;
    private HashMap<Integer, PropertyDetails> apartments = new HashMap<Integer, PropertyDetails>();

    public ApartmentBuilding(Address address, String civicAddress) {
        this.address = address;
        this.civicAddress = civicAddress;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCivicAddress() {
        return civicAddress;
    }

    public void setCivicAddress(String civicAddress) {
        this.civicAddress = civicAddress;
    }

    public HashMap<Integer, PropertyDetails> getApartments() {
        return apartments;
    }

    public void setApartments(HashMap<Integer, PropertyDetails> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "ApartmentBuilding{" +
                "address=" + address +
                ", civicAddress='" + civicAddress + '\'' +
                ", apartments=" + apartments +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public String addProperty() {
        return null;
    }
}

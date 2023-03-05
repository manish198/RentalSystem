package view;

import model.property.concrete_property.ApartmentBuilding;
import model.property.concrete_property.Condo;
import model.property.concrete_property.House;
import model.request_model.ApartmentRequest;
import model.tenant.Tenant;
import interfaces.RentalSystemInterface;
import model.property.Property;
import service.RentalServices;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystemScreen {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        welcomeMessage();
    }
    public static void welcomeMessage() {
        System.out.println("Welcome to the Rental System");
        init();
    }
    public static void init(){
        RentalSystemInterface rentalInterface=new RentalServices();
        showMenu();
        String userInput = sc.nextLine();
        while (!userInput.equals("10")) {
            switch (userInput) {
                case "1":{
                    showProperty();
                    String userPropertyInput=sc.nextLine();
                    while(!userPropertyInput.equals("4")){
                        System.out.println("Enter Postal Code");
                        String postalCode=sc.nextLine().trim();
                        System.out.println("Enter Province");
                        String province=sc.nextLine().trim();
                        System.out.println("Enter City Name");
                        String cityName=sc.nextLine().trim();
                        String propertyType="";
                        String result="";
                        switch (userPropertyInput){
                            case "1":{
                                propertyType="APARTMENT";
                                System.out.println("Enter Civic Address");
                                String civicAddress=sc.nextLine().trim();
                                System.out.println("Please enter no. of units to add");
                                int numberOfUnits=Integer.parseInt(sc.nextLine().trim());
                                ArrayList<ApartmentRequest> apartmentList = new ArrayList<>();
                                for (int i=0;i<numberOfUnits;i++){
                                    System.out.println("Enter Apt Number");
                                    int aptNumber=Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Number of Bedrooms");
                                    int numberOfBedRooms=Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Number of Bathrooms");
                                    int numberOfBathRooms=Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Square Foot");
                                    double squareFoot=Double.parseDouble(sc.nextLine().trim());
                                    apartmentList.add(new ApartmentRequest(aptNumber,squareFoot,numberOfBedRooms,
                                            numberOfBathRooms));
                                }
                                result=rentalInterface.addProperty(propertyType,postalCode,cityName, province,
                                        civicAddress,"",0,
                                        0,0,0,0,apartmentList);
                                System.out.println(result);

                                break;

                            }

                            case "2":{
                                propertyType="CONDO";
                                System.out.println("Enter Street name");
                                String streetName=sc.nextLine().trim();
                                System.out.println("Enter Street number");
                                int streetNumber=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Unit Number");
                                int unitNumber=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bedrooms");
                                int numberOfBedRooms=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bathrooms");
                                int numberOfBathRooms=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Square Foot");
                                double squareFoot=Double.parseDouble(sc.nextLine().trim());
                                result=rentalInterface.addProperty(propertyType,postalCode,cityName,
                                        province,"",streetName,streetNumber,unitNumber,
                                        squareFoot,numberOfBedRooms,numberOfBathRooms,null);
                                System.out.println(result);
                                break;
                            }

                            case "3":{
                                propertyType="HOUSE";
                                System.out.println("Enter Street name");
                                String streetName=sc.nextLine().trim();
                                System.out.println("Enter Street number");
                                int streetNumber=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bedrooms");
                                int numberOfBedRooms=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bathrooms");
                                int numberOfBathRooms=Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Square Foot");
                                double squareFoot=Double.parseDouble(sc.nextLine().trim());
                                result=rentalInterface.addProperty(propertyType,postalCode,cityName,
                                        province,"",streetName,streetNumber,0,
                                        squareFoot,numberOfBedRooms,numberOfBathRooms,null);
                                System.out.println(result);
                                break;
                            }

                            default:{
                                System.out.println("Invalid Property Type");
                                break;
                            }

                        }
                        break;
                    }
                    break;
                }
                case "2":{
                    System.out.println("Enter First Name");
                    String firstName=sc.nextLine().trim();
                    System.out.println("Enter Last Name");
                    String lastName=sc.nextLine().trim();
                    String name = firstName + " " + lastName;
                    System.out.println("Enter age");
                    int age=Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Enter email");
                    String email=sc.nextLine().trim();
                    String res = rentalInterface.addTenant(name,age,email);
                    System.out.println(res);
                    break;
                }
                case "3":
                    System.out.println("Rent a unit");
                    break;
                case "4":{
                    System.out.println("Display properties");
                    ArrayList<Property> allPropertiesList= rentalInterface.displayProperty();
                    displayProperties(allPropertiesList);
                    break;
                }
                case "5":{
                    ArrayList<Tenant> tenantList = rentalInterface.displayTenant();
                    displayTenants(tenantList);
                    break;
                }
                case "6":
                    System.out.println("Display rented units");
                    break;
                case "7":
                    System.out.println("Display vacant units");
                    break;
                case "8":
                    System.out.println("Display all leases");
                    break;
                case "9":{
                    System.out.println("Please select 1. for rent paid and 2. for rent not paid");
                    String rentPaidOrNot=sc.nextLine();
                    ArrayList<Tenant> tenantList = null;
                    if(rentPaidOrNot.equals("1")){
                        tenantList = rentalInterface.displayRentPaidStatus(true);
                    }else if(rentPaidOrNot.equals("2")){
                        tenantList = rentalInterface.displayRentPaidStatus(false);
                    }
                    displayTenants(tenantList);
                }
                default:
                    System.out.println("Invalid input");
                    break;
            }
            showMenu();
            userInput = sc.nextLine();
        }
        System.out.println("Thank you for using the Rental System");
    }
    public static void showMenu(){
        System.out.println("Please select an option:\n" +
                "1. Add a property\n" +
                "2. Add a tenant\n" +
                "3. Rent a unit\n" +
                "4. Display properties\n" +
                "5. Display tenants\n" +
                "6. Display rented units\n" +
                "7. Display vacant units\n" +
                "8. Display all leases\n" +
                "9. Rent paid or not\n" +
                "10. Exit" );
    }

    public static void showProperty(){
        System.out.println("Please select type of property to add:\n" +
                "1. Apartment\n" +
                "2. Condo\n" +
                "3. House\n"+
                "4. Cancel\n"
        );
    }

    public static void displayProperties(ArrayList<Property> allPropertiesList){
//        ArrayList<PropertyDisplay> propertyListToDisplay = new ArrayList<>();
        for(Property property : allPropertiesList){
            if(property instanceof Condo){
                ((Condo) property).displayProperty();
            }
            else if(property instanceof House){
                ((House) property).displayProperty();
            }
            else if(property instanceof ApartmentBuilding){
                ((ApartmentBuilding) property).displayProperty();
            }
        }
    }
    public static void displayTenants(ArrayList<Tenant> tenantList) {
        for (Tenant tenant:tenantList)
            System.out.println("---------------------------------\n" +
                    tenant.toString() +
                    "---------------------------------\n");
    }
}

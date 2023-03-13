package view;

import controller.PropertyController;
import controller.RentController;
import controller.TenantController;
import model.lease.Lease;
import model.property.concrete_property.ApartmentBuilding;
import model.property.concrete_property.Condo;
import model.property.concrete_property.House;
import model.request_model.ApartmentRequest;
import model.response_model.LeasePropertyResponseObject;
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

    public static void init() {
        RentalSystemInterface rentalInterface = new RentalServices();
        TenantController tenantController = new TenantController();
        PropertyController propertyController=new PropertyController();
        RentController rentController=new RentController();
        showMenu();
        String userInput = sc.nextLine();
        while (!userInput.equals("10")) {
            switch (userInput) {
                case "1": {
                    showProperty();
                    String userPropertyInput = sc.nextLine();
                    while (!userPropertyInput.equals("4")) {
                        System.out.println("Enter Postal Code");
                        String postalCode = sc.nextLine().trim();
                        System.out.println("Enter Province");
                        String province = sc.nextLine().trim();
                        System.out.println("Enter City Name");
                        String cityName = sc.nextLine().trim();
                        String propertyType = "";
                        String result = "";
                        switch (userPropertyInput) {
                            case "1": {
                                propertyType = "APARTMENT";
                                System.out.println("Enter Civic Address");
                                String civicAddress = sc.nextLine().trim();
                                System.out.println("Please enter no. of units to add");
                                int numberOfUnits = Integer.parseInt(sc.nextLine().trim());
                                ArrayList<ApartmentRequest> apartmentList = new ArrayList<>();
                                for (int i = 0; i < numberOfUnits; i++) {
                                    System.out.println("Enter PropertyID");
                                    String propertyID = sc.nextLine().trim();
                                    System.out.println("Enter Apt Number");
                                    int aptNumber = Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Number of Bedrooms");
                                    int numberOfBedRooms = Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Number of Bathrooms");
                                    int numberOfBathRooms = Integer.parseInt(sc.nextLine().trim());
                                    System.out.println("Enter Square Foot");
                                    double squareFoot = Double.parseDouble(sc.nextLine().trim());
                                    apartmentList.add(new ApartmentRequest(propertyID, aptNumber, squareFoot, numberOfBedRooms,
                                            numberOfBathRooms));
                                }
                                result = propertyController.addProperty(rentalInterface,"", propertyType, postalCode, cityName, province,
                                        civicAddress, "", 0,
                                        0, 0, 0, 0, apartmentList);
                                System.out.println(result);

                                break;

                            }

                            case "2": {
                                propertyType = "CONDO";
                                System.out.println("Enter PropertyID");
                                String propertyID = sc.nextLine().trim();
                                System.out.println("Enter Street name");
                                String streetName = sc.nextLine().trim();
                                System.out.println("Enter Street number");
                                int streetNumber = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Unit Number");
                                int unitNumber = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bedrooms");
                                int numberOfBedRooms = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bathrooms");
                                int numberOfBathRooms = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Square Foot");
                                double squareFoot = Double.parseDouble(sc.nextLine().trim());
                                result = propertyController.addProperty(rentalInterface,propertyID, propertyType, postalCode, cityName,
                                        province, "", streetName, streetNumber, unitNumber,
                                        squareFoot, numberOfBedRooms, numberOfBathRooms, null);
                                System.out.println(result);
                                break;
                            }

                            case "3": {
                                propertyType = "HOUSE";
                                System.out.println("Enter PropertyID");
                                String propertyID = sc.nextLine().trim();
                                System.out.println("Enter Street name");
                                String streetName = sc.nextLine().trim();
                                System.out.println("Enter Street number");
                                int streetNumber = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bedrooms");
                                int numberOfBedRooms = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Number of Bathrooms");
                                int numberOfBathRooms = Integer.parseInt(sc.nextLine().trim());
                                System.out.println("Enter Square Foot");
                                double squareFoot = Double.parseDouble(sc.nextLine().trim());
                                result = propertyController.addProperty(rentalInterface,propertyID, propertyType, postalCode, cityName,
                                        province, "", streetName, streetNumber, 0,
                                        squareFoot, numberOfBedRooms, numberOfBathRooms, null);
                                System.out.println(result);
                                break;
                            }

                            default: {
                                System.out.println("Invalid Property Type");
                                break;
                            }

                        }
                        break;
                    }
                    break;
                }
                case "2": {
                    System.out.println("Enter First Name");
                    String firstName = sc.nextLine().trim();
                    System.out.println("Enter Last Name");
                    String lastName = sc.nextLine().trim();
                    String name = firstName + " " + lastName;
                    System.out.println("Enter age");
                    int age = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Enter email");
                    String email = sc.nextLine().trim();
                    String res = tenantController.addNewTenant(rentalInterface, name, age, email);
                    System.out.println(res);
                    break;
                }
                case "3": {
                    System.out.println("Rent a unit");
                    System.out.println("Enter PropertyID");
                    String propertyID = sc.nextLine().trim();
                    System.out.println("Enter TenantID");
                    String tenantID = sc.nextLine().trim();
                    System.out.println("Enter Lease Info");
                    String leaseInfo = sc.nextLine().trim();
                    System.out.println("Enter Lease Start Date");
                    String leaseStartDate = sc.nextLine().trim();
                    System.out.println("Enter Lease End Date");
                    String leaseEndDate = sc.nextLine().trim();
                    System.out.println("Enter rent amount");
                    double rentAmount = Double.parseDouble(sc.nextLine().trim());
                    String res = rentController.rentUnit(rentalInterface,propertyID, tenantID, leaseInfo, leaseStartDate,
                            leaseEndDate, rentAmount);
                    System.out.println(res);
                    break;
                }

                case "4": {
                    System.out.println("Display properties");
                    ArrayList<Property> allPropertiesList= propertyController.displayProperty(rentalInterface);
                    displayProperties(allPropertiesList,"nocheck");
                    break;
                }
                case "5": {
                    ArrayList<Tenant> tenantList = tenantController.displayAllTenants(rentalInterface);
                    displayTenants(tenantList);
                    break;
                }
                case "6": {
                    System.out.println("Display rented units");
                    ArrayList<Property> localDisplayRentedUnit=rentalInterface.displayRentedUnit();
                    displayProperties(localDisplayRentedUnit,"rented");
                    break;
                }
                case "7": {
                    System.out.println("Display vacant units");
                    ArrayList<Property> localDisplayVacantUnit=rentalInterface.displayRentedUnit();
                    displayProperties(localDisplayVacantUnit,"vacant");
                    break;
                }
                case "8": {
                    System.out.println("Display all leases");
                    ArrayList<LeasePropertyResponseObject> allLease = rentalInterface.displayLeases();
                    displayLease(allLease);
                    break;
                }

                case "9": {
                    System.out.println("Please select 1. for rent paid and 2. for rent not paid");
                    String rentPaidOrNot = sc.nextLine();
                    ArrayList<Tenant> tenantList = null;
                    if (rentPaidOrNot.equals("1")) {
                        tenantList = rentalInterface.displayRentPaidStatus(true);
                    } else if (rentPaidOrNot.equals("2")) {
                        tenantList = rentalInterface.displayRentPaidStatus(false);
                    }
                    displayTenants(tenantList);
                    break;
                }
                case "11": {
                    System.out.println("Enter tenant ID");
                    String tenantID = sc.nextLine().trim();
                    String res = tenantController.payTenantRent(rentalInterface,tenantID);
                    System.out.println(res);
                    break;
                }
                case "12": {
                    System.out.println("Enter property ID");
                    String propertyID = sc.nextLine().trim();
                    String res = propertyController.makePropertyAvailable(rentalInterface,propertyID);
                    System.out.println(res);
                    break;
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

    public static void showMenu() {
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
                "10. Exit\n" +
                "11. Pay rent\n" +
                "12. Make Property Available");
    }

    public static void showProperty() {
        System.out.println("Please select type of property to add:\n" +
                "1. Apartment\n" +
                "2. Condo\n" +
                "3. House\n"+
                "4. Cancel\n"
        );
    }

    public static void displayProperties(ArrayList<Property> allPropertiesList,String check){
//        ArrayList<PropertyDisplay> propertyListToDisplay = new ArrayList<>();
        for(Property property : allPropertiesList){
            if(property instanceof Condo){
                ((Condo) property).displayProperty();
            }
            else if(property instanceof House){
                ((House) property).displayProperty();
            }
            else if(property instanceof ApartmentBuilding){
                if(check.equals("rented"))
                {
                    ((ApartmentBuilding) property).displayRentedProperty();
                }
                else if(check.equals("vacant")) {
                    ((ApartmentBuilding) property).displayVacantProperty();
                }
                else {
                    ((ApartmentBuilding) property).displayProperty();
                }
            }
        }
    }

    public static void displayTenants(ArrayList<Tenant> tenantList) {
        for (Tenant tenant : tenantList)
            System.out.println("---------------------------------\n" +
                    tenant.toString() +
                    "---------------------------------\n");
    }

    public static void displayLease(ArrayList<LeasePropertyResponseObject> allLeaseList) {
        for (LeasePropertyResponseObject leasePropertyResponseObject : allLeaseList) {
            System.out.println("---------------------------------\n" +
                    leasePropertyResponseObject.toString() +
                    "---------------------------------\n");
        }
    }
}

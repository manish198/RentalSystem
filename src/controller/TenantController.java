package controller;

import interfaces.RentalSystemInterface;
import model.tenant.Tenant;

import java.util.ArrayList;

public class TenantController {
    public TenantController() {
    }

    public String addNewTenant(RentalSystemInterface rentalInterface, String name, int age, String email) {
        return rentalInterface.addTenant(name,age,email);
    }
    public ArrayList<Tenant> displayAllTenants(RentalSystemInterface rentalInterface) {
        return rentalInterface.displayTenant();
    }
    public String payTenantRent(RentalSystemInterface rentalInterface, String tenantID) {
        return rentalInterface.payRent(tenantID);
    }
    public ArrayList<Tenant> rentPaidStatus(RentalSystemInterface rentalSystemInterface)
    {
        return rentalSystemInterface.displayRentPaidStatus(true);
    }
    public ArrayList<Tenant> rentNotPaidStatus(RentalSystemInterface rentalSystemInterface)
    {
        return rentalSystemInterface.displayRentPaidStatus(false);
    }
//    public String TenantRentStatus(RentalSystemInterface rentalInterface,String tenantID)
//    {
//       // return rentalInterface.TenantRentStatus(tenantID);
//    }
}

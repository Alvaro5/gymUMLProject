package fr.efrei.factory;

import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee (int id, String firstName, String lastName, boolean inHolydays, String bank_details){
        if(Helper.isNullOrEmpty(String.valueOf(id)) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(firstName)){
            return null;
        }

        return new Employee.EmployeeBuilder().setId(id)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setInHolydays(inHolydays)
                .setBank_details(bank_details)
                .build();
    }

    public static Employee buildEmployee (String firstName, String lastName, boolean inHolydays, String bank_details){
        if(Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(firstName)){
            return null;
        }

        int id = Helper.generateId();
        return new Employee.EmployeeBuilder().setId(id)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setInHolydays(inHolydays)
                .setBank_details(bank_details)
                .build();
    }

}

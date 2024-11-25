package fr.efrei.factory;

import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee (int id, String firstName, String lastName, boolean onRestDAy, String bankDetails){
        if(Helper.isNullOrEmpty(String.valueOf(id)) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(firstName)){
            return null;
        }

        return new Employee.EmployeeBuilder().setId(id)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setOnRestDay(onRestDAy)
                .setBank_details(bankDetails)
                .build();
    }

    public static Employee buildEmployee (String firstName, String lastName, boolean onRestDAy, String bankDetails){
        if(Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(firstName)){
            return null;
        }

        int id = Helper.generateId();
        return new Employee.EmployeeBuilder().setId(id)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setOnRestDay(onRestDAy)
                .setBank_details(bankDetails)
                .build();
    }

}

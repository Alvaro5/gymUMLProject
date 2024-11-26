package fr.efrei.factory;

import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class EmployeeFactory {



    public static Employee buildEmployee (int employeeId, String firstName, String lastName, boolean onRestDAy, String bankDetails){
        if(Helper.isNullOrEmpty(String.valueOf(employeeId))){
            System.out.println("id is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(lastName)){
            System.out.println("last name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(firstName)){
            System.out.println("first name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(onRestDAy))){
            System.out.println("rest day is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(bankDetails)){
            System.out.println("bank details are incorrect");
            return null;
        }

        return new Employee.EmployeeBuilder().setEmployeeId(employeeId)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setOnRestDay(onRestDAy)
                .setBankDetails(bankDetails)
                .build();
    }

    public static Employee buildEmployee (String firstName, String lastName, boolean onRestDAy, String bankDetails){
        if (Helper.isNullOrEmpty(lastName)){
            System.out.println("last name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(firstName)){
            System.out.println("first name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(onRestDAy))){
            System.out.println("rest day is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(bankDetails)){
            System.out.println("bank details are incorrect");
            return null;
        }

        int employeeId = Helper.generateId();
        return new Employee.EmployeeBuilder().setEmployeeId(employeeId)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setOnRestDay(onRestDAy)
                .setBankDetails(bankDetails)
                .build();
    }

}

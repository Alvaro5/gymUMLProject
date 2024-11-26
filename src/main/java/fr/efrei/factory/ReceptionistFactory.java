package fr.efrei.factory;

import fr.efrei.domain.Receptionist;
import fr.efrei.util.Helper;

public class ReceptionistFactory {
    public static Receptionist buildReceptionist(double hourlyRate, boolean[] workingHours, int employeeId, String lastName, String firstName, boolean onRestDay, String bankDetails){
        if(Helper.isNullOrEmpty(String.valueOf(hourlyRate))){
            System.out.println("hourly rate is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(workingHours))){
            System.out.println("working hours is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(employeeId))){
            System.out.println("employee id is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(lastName))){
            System.out.println("last name is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(firstName))){
            System.out.println("first name is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(onRestDay))){
            System.out.println("rest day is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(bankDetails))){
            System.out.println("bank details are incorrect");
            return null;
        }
        return new Receptionist.ReceptionistBuilder().setWorkingHours(workingHours)
                .setHourlyRate(hourlyRate)
                .setBankDetails(bankDetails)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setEmployeeId(employeeId)
                .setOnRestDay(onRestDay)
                .build();
    }

    public static Receptionist buildReceptionist(double hourlyRate, boolean[] workingHours, String lastName, String firstName, boolean onRestDay, String bankDetails){
        if(Helper.isNullOrEmpty(String.valueOf(hourlyRate))){
            System.out.println("hourly rate is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(workingHours))){
            System.out.println("working hours is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(lastName))){
            System.out.println("last name is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(firstName))){
            System.out.println("first name is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(onRestDay))){
            System.out.println("rest day is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(bankDetails))){
            System.out.println("bank details are incorrect");
            return null;
        }

        int employeeId = Helper.generateId();
        return new Receptionist.ReceptionistBuilder().setWorkingHours(workingHours)
                .setHourlyRate(hourlyRate)
                .setBankDetails(bankDetails)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setEmployeeId(employeeId)
                .setOnRestDay(onRestDay)
                .build();
    }
}

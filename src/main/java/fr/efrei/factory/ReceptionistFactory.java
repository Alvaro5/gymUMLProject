package fr.efrei.factory;

import fr.efrei.domain.Receptionist;
import fr.efrei.util.Helper;

public class ReceptionistFactory {
    public static Receptionist buildReceptionist(int employeeId, String lastName, String firstName, boolean onRestDay, String bankDetails, double hourlyRate, boolean[] workingHours) {
        if(Helper.isNullOrEmpty(String.valueOf(hourlyRate)) || hourlyRate > 15.00) {
            System.out.println("hourly rate is missing or incorrect");
            return null;
        }
        if(workingHours.length == 0) {
            System.out.println("working hours is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(employeeId))) {
            System.out.println("employee id is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(lastName)) {
            System.out.println("last name is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(firstName)) {
            System.out.println("first name is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(onRestDay))) {
            System.out.println("rest day is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(bankDetails) || bankDetails.length() > 34) {
            System.out.println("bank details are missing or incorrect");
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

    public static Receptionist buildReceptionist(String lastName, String firstName, boolean onRestDay, String bankDetails, double hourlyRate, boolean[] workingHours) {
        if (Helper.isNullOrEmpty(String.valueOf(hourlyRate)) || hourlyRate > 15.00) {
            System.out.println("hourly rate is missing");
            return null;
        }
        if(workingHours.length == 0) {
            System.out.println("working hours is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(lastName)) {
            System.out.println("last name is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(firstName)) {
            System.out.println("first name is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(onRestDay))) {
            System.out.println("rest day is missing");
            return null;
        }
        if(Helper.isNullOrEmpty(bankDetails) || bankDetails.length() > 34) {
            System.out.println("bank details are missing or incorrect");
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

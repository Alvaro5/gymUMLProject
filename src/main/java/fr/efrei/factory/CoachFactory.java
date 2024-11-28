package fr.efrei.factory;

import fr.efrei.domain.Coach;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class CoachFactory {
    public static Coach buildCoach(int employeeId, String lastName, String firstName, boolean onRestDay, String bankDetails, String sportType, double hourlyRate, boolean[] availability) {
        if (Helper.isNullOrEmpty(sportType)) {
            System.out.println("sport type is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(hourlyRate)) || hourlyRate > 30.00) {
            System.out.println("hourly rate is missing or incorrect");
            return null;
        }
        if (availability.length == 0) {
            System.out.println("availability is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(employeeId))) {
            System.out.println("employee id is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(lastName)) {
            System.out.println("last name is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(firstName)) {
            System.out.println("first name is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(onRestDay))){
            System.out.println("rest day is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(bankDetails) || bankDetails.length() > 34) {
            System.out.println("bank details are missing or incorrect");
            return null;
        }
        return new Coach.CoachBuilder().setHourlyRate(hourlyRate)
                .setSportType(Coach.SportType.valueOf(sportType.toUpperCase()))
                .setAvailability(availability)
                .setBankDetails(bankDetails)
                .setOnRestDay(onRestDay)
                .setEmployeeId(employeeId)
                .setLastName(lastName)
                .setFirstName(firstName)
                .build();
    }

    public static Coach buildCoach(String lastName, String firstName, boolean onRestDay, String bankDetails, String sportType, double hourlyRate, boolean[] availability) {
        if (Helper.isNullOrEmpty(String.valueOf(sportType))) {
            System.out.println("sport is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(hourlyRate)) || hourlyRate > 30.00) {
            System.out.println("hourly rate is missing");
            return null;
        }
        if (availability.length == 0) {
            System.out.println("availability is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(lastName))) {
            System.out.println("last name is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(firstName))) {
            System.out.println("first name is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(onRestDay))) {
            System.out.println("rest day is missing");
            return null;
        }
        if (Helper.isNullOrEmpty(bankDetails) || bankDetails.length() > 34) {
            System.out.println("bank details are missing or incorrect");
            return null;
        }

        int employeeId = Helper.generateId();

        return new Coach.CoachBuilder().setHourlyRate(hourlyRate)
                .setSportType(Coach.SportType.valueOf(sportType.toUpperCase()))
                .setAvailability(availability)
                .setBankDetails(bankDetails)
                .setOnRestDay(onRestDay)
                .setEmployeeId(employeeId)
                .setLastName(lastName)
                .setFirstName(firstName)
                .build();
    }
}

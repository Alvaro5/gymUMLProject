package fr.efrei.factory;

import fr.efrei.domain.Coach;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class CoachFactory {
    public static Coach buildCoach(String sportType, double hourlyRate, boolean[] availability, int employeeId, String lastName, String firstName, boolean onRestDay, String bankDetails){
        if(Helper.isNullOrEmpty(sportType)){
            System.out.println("sport is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(hourlyRate))){
            System.out.println("hourly rate is incorrect");
            return null;
        }
        if(Helper.isNullOrEmpty(String.valueOf(availability))){
            System.out.println("availability is incorrect");
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

    public static Coach coachMember(String sportType, double hourlyRate, boolean[] availability, String lastName, String firstName, boolean onRestDay, String bankDetails) {
        if (Helper.isNullOrEmpty(String.valueOf(sportType))) {
            System.out.println("sport is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(hourlyRate))) {
            System.out.println("hourly rate is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(availability))) {
            System.out.println("availability is incorrect");
            return null;
        }

        if (Helper.isNullOrEmpty(String.valueOf(lastName))) {
            System.out.println("last name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(firstName))) {
            System.out.println("first name is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(onRestDay))) {
            System.out.println("rest day is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(String.valueOf(bankDetails))) {
            System.out.println("bank details are incorrect");
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

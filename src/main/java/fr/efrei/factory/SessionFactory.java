package fr.efrei.factory;

import fr.efrei.domain.*;
import fr.efrei.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SessionFactory {
    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private static final LocalTime END_TIME = LocalTime.of(22, 0);

    public static Session buildSession(int sessionID, String sportType, LocalDate date, LocalTime time, Coach coach, Receptionist receptionist, List<Member> members) {
        if (coach == null) {
            System.out.println("Coach is incorrect");
            return null;
        }

        if (receptionist == null) {
            System.out.println("Receptionist is incorrect");
            return null;
        }

        if (members.isEmpty()){
            System.out.println("There are no members participating in the session");
            return null;
        }

        if (Helper.isNullOrEmpty(String.valueOf(sessionID)) || Helper.isNullOrEmpty(sportType)){
            System.out.println("Empty ID or/and empty sport type");
            return null;
        }

        if (Helper.emptyTime(time) || Helper.emptyDate(date)) {
            System.out.println("Date or/and time for the session are missing");
            return null;
        }

        if (time.compareTo(START_TIME) < 0 || time.compareTo(END_TIME) > 0) {
            System.out.println("Time for the session isn't included in gym opening hours");
            return null;
        }

        return new Session.Builder().setSessionID(sessionID)
                .setSportType(Session.SportType.valueOf(sportType))
                .setTime(time)
                .setDate(date)
                .setCoach(coach)
                .setReceptionist(receptionist)
                .setListMembers(members)
                .build();
    }

    public static Session buildSession(String sportType, LocalDate date, LocalTime time, Coach coach, Receptionist receptionist, List<Member> members) {
        if (coach == null) {
            System.out.println("Coach is incorrect");
            return null;
        }

        if (receptionist == null) {
            System.out.println("Receptionist is incorrect");
            return null;
        }

        if (members.isEmpty()){
            System.out.println("There are no members participating in the session");
            return null;
        }

        if (Helper.isNullOrEmpty(sportType)){
            System.out.println("Empty sport type");
            return null;
        }

        if (Helper.emptyTime(time) || Helper.emptyDate(date)) {
            System.out.println("Date or/and time for the session are missing");
            return null;
        }

        if (time.compareTo(START_TIME) < 0 || time.compareTo(END_TIME) > 0) {
            System.out.println("Time for the session isn't included in gym opening hours");
            return null;
        }

        int sessionID = Helper.generateId();

        return new Session.Builder().setSessionID(sessionID)
                .setSportType(Session.SportType.valueOf(sportType))
                .setTime(time)
                .setDate(date)
                .setCoach(coach)
                .setReceptionist(receptionist)
                .setListMembers(members)
                .build();
    }
}

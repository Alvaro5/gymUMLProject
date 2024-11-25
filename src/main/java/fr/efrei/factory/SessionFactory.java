package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Session;
import fr.efrei.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SessionFactory {
    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private static final LocalTime END_TIME = LocalTime.of(22, 0);

    public static Session buildSession(boolean coach, String sport, LocalDate date, LocalTime time, List<Customer> customers) {
        if (Helper.isNullOrEmpty(String.valueOf(coach)) || Helper.isNullOrEmpty(sport)|| Helper.isNullOrEmpty(String.valueOf(date)) || Helper.isNullOrEmpty(String.valueOf(time))){
            return null;
        }

        if (customers.isEmpty()){
            return null;
        }

        if (time.compareTo(START_TIME) < 0 || time.compareTo(END_TIME) > 0 || Helper.emptyTime(time)) {
            return null;
        }

        return new Session.Builder().setCoach(coach)
                .setSport(sport)
                .setDate(date)
                .setTime(time)
                .build();
    }
}

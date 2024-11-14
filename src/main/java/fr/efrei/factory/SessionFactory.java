package fr.efrei.factory;

import fr.efrei.domain.Session;
import fr.efrei.util.Helper;

public class SessionFactory {
    public static Session buildSession(boolean coach, String sport, String date, String time){
        if (Helper.isNullOrEmpty(String.valueOf(coach)) || Helper.isNullOrEmpty(sport)|| Helper.isNullOrEmpty(date) || Helper.isNullOrEmpty(time)){
            return null;
        }

        return new Session.Builder().setCoach(coach)
                .setSport(sport)
                .setDate(date)
                .setTime(time)
                .build();
    }
}

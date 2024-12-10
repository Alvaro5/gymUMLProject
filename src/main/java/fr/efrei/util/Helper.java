package fr.efrei.util;
import java.time.*;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) return true;
        return false;
    }

    public static boolean emptyTime(LocalTime time) {
        if (time == null) return true;
        return false;
    }

    public static boolean emptyDate(LocalDate date) {
        if (date == null) return true;
        return false;
    }

    public static boolean endBeforeStart(LocalDate start, LocalDate end) {
        return end.isBefore(start);
    }

    public static int generateId() {
        return Integer.parseInt(String.valueOf(UUID.randomUUID()));
    }

    public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        return p.matcher(email).matches();
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        String phoneNumberRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        Pattern p = Pattern.compile(phoneNumberRegex);
        return p.matcher(phoneNumber).matches();
    }
}

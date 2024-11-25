package fr.efrei.util;

import java.time.LocalTime;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) return true;
        return false;
    }

    public static boolean emptyTime(LocalTime time) {
        if (time == null) return true;
        return false;
    }

    public static int generateId() {
        return Integer.parseInt(String.valueOf(UUID.randomUUID()));
    }
}

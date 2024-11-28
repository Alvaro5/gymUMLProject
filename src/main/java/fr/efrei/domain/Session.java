package fr.efrei.domain;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private static final int MAX_CAPACITY = 5;
    private int sessionID;
    private SportType sportType;
    private LocalDate date;
    private LocalTime time;
    private Coach coach;
    private Receptionist receptionist;
    private List<Member> listMembers = new ArrayList<>(MAX_CAPACITY);


    public enum SportType {
        SPINNING, RUNNING, YOGA, WEIGHTLIFTING, BOXING, PERSONALIZED
    }

    private Session() {}

    private Session(Builder builder) {
        this.sessionID = builder.sessionID;
        this.sportType = builder.sportType;
        this.date = builder.date;
        this.time = builder.time;
        this.coach = builder.coach;
        this.receptionist = builder.receptionist;
        this.listMembers = builder.listMembers;
    }

    public int getSessionID() {
        return sessionID;
    }

    public SportType getSportType() {
        return sportType;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Coach getCoach() {
        return coach;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public List<Member> getListMembers() {
        return listMembers;
    }

    public boolean isBooked() {
        if (listMembers.size() == 5)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionID=" + sessionID +
                ", sportType=" + sportType +
                ", date=" + date +
                ", time=" + time +
                ", coach=" + coach +
                ", receptionist=" + receptionist +
                ", listMembers=" + listMembers +
                '}';
    }

    public static class Builder{

        private static final int MAX_CAPACITY = 5;
        private int sessionID;
        private SportType sportType;
        private LocalDate date;
        private LocalTime time;
        private Coach coach;
        private Receptionist receptionist;
        private List<Member> listMembers = new ArrayList<>(MAX_CAPACITY);

        public Builder setSessionID(int sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder setSportType(SportType sportType) {
            this.sportType = sportType;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder setCoach(Coach coach) {
            this.coach = coach;
            return this;
        }

        public Builder setReceptionist(Receptionist receptionist) {
            this.receptionist = receptionist;
            return this;
        }

        public Builder setListMembers(List<Member> listMembers) {
            this.listMembers = listMembers;
            return this;
        }

        public Builder copy(Session session) {
            this.sessionID = session.sessionID;
            this.date = session.date;
            this.time = session.time;
            this.sportType = session.sportType;
            this.coach = session.coach;
            this.receptionist = session.receptionist;
            this.listMembers = session.listMembers;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}

package fr.efrei.domain;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private boolean coach;
    private String sport;
    private LocalDate date;
    private LocalTime time;
    private List<Member> listMembers = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

    private Session() {
    }

    private Session(Builder builder) {
        this.coach = builder.coach;
        this.sport = builder.sport;
        this.date = builder.date;
        this.time = builder.time;
    }

    public boolean getCoach() {
        return coach;
    }

    public String getSport() {
        return sport;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<Member> getListCustomers() {
        return listMembers;
    }

    public boolean addCustomer(Member customer){
        if(MAX_CAPACITY > listMembers.size()){
            listMembers.add(customer);
            return true;
        }
        else {
            System.out.println("The session is full. Please take another session.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Session{" +
                "coach='" + coach + '\'' +
                ", sport='" + sport + '\'' +
                ", date=" + date +
                ", startSession=" + time +
                ", listCustomers=" + listMembers +
                '}';
    }

    public static class Builder{
        private boolean coach;
        private String sport;
        private LocalDate date;
        private LocalTime time;
        private List<Member > listCustomers = new ArrayList<>();


        public Builder setCoach(boolean coach) {
            this.coach = coach;
            return this;
        }

        public Builder setSport(String sport) {
            this.sport = sport;
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

        public Session build() {
            return new Session(this);
        }
    }
}

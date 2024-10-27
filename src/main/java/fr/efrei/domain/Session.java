package fr.efrei.domain;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private boolean coach;
    private String sport;
    private String date;
    private String time;
    private List<Customer> listCustomers = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public List<Customer> getListCustomers() {
        return listCustomers;
    }

    public boolean addCustomer(Customer customer){
        if(MAX_CAPACITY > listCustomers.size()){
            listCustomers.add(customer);
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
                ", listCustomers=" + listCustomers +
                '}';
    }

    public static class Builder{
        private boolean coach;
        private String sport;
        private String date;
        private String time;

        public Builder setCoach(boolean coach) {
            this.coach = coach;
            return this;
        }

        public Builder setSport(String sport) {
            this.sport = sport;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}

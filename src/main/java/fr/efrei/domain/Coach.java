package fr.efrei.domain;

import java.util.Arrays;

public class Coach extends Employee{
    private static final int MAX_WORKING_HOURS = 10;
    private String sport;
    private String workingHours;
    private boolean[] availability = new boolean[MAX_WORKING_HOURS];

    public Coach(){}
    public Coach(CoachBuilder builder) {
        super(builder);
        this.sport = builder.sport;
        this.workingHours = builder.workingHours;
        this.availability = builder.availability;
    }

    public String getSport() {
        return sport;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public boolean[] getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return super.toString() + "Coach{" +
                "sport='" + sport + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", availability=" + Arrays.toString(availability) +
                '}';
    }

    public static class CoachBuilder extends Employee.EmployeeBuilder{
        private String sport;
        private String workingHours;
        private boolean[] availability = new boolean[MAX_WORKING_HOURS];

        public CoachBuilder setSport(String sport) {
            this.sport = sport;
            return this;
        }
        public CoachBuilder setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
            return this;
        }
        public CoachBuilder setAvailability(boolean[] availability) {
            this.availability = availability;
            return this;
        }
        public Coach build() {
            return new Coach(this);
        }    }
}

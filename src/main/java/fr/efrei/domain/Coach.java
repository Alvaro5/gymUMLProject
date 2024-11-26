package fr.efrei.domain;

import java.util.Arrays;

public class Coach extends Employee{

    private SportType sportType ;
    private double hourlyRate;
    private static final int MAX_WORKING_HOURS = 10;
    private boolean[] availability = new boolean[MAX_WORKING_HOURS];
    public enum SportType {
        RUNNING, SPINNING, YOGA, WEIGHTLIFTING, BOXING, PERSONALIZED
    }

    private Coach() {}

    private Coach(CoachBuilder builder) {
        super(builder);
        this.sportType = builder.sportType;
        this.hourlyRate = builder.hourlyRate;
        this.availability = builder.availability;
    }

    public SportType getSpeciality() {
        return sportType;
    }

    public double getWorkingHours() {
        return hourlyRate;
    }

    public boolean[] getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return super.toString() + "Coach{" +
                "sportType='" + sportType + '\'' +
                ", workingHours='" + hourlyRate + '\'' +
                ", availability=" + Arrays.toString(availability) +
                '}';
    }

    public static class CoachBuilder extends Employee.EmployeeBuilder{
        private SportType sportType;
        private double hourlyRate;
        private boolean[] availability = new boolean[MAX_WORKING_HOURS];

        public CoachBuilder setSportType(SportType sportType) {
            this.sportType = sportType;
            return this;
        }
        public CoachBuilder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
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

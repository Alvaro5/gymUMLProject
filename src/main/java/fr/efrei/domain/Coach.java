package fr.efrei.domain;

import java.util.Arrays;

public class Coach extends Employee{

    private SportType sportType ;
    private double hourlyRate;
    public static final int MAX_WORKING_HOURS = 10;
    private boolean[] availability = new boolean[MAX_WORKING_HOURS];
    public enum SportType {
        RUNNING, SPINNING, YOGA, WEIGHTLIFTING, BOXING, PERSONALIZED
    }

    public Coach() {}

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
        return String.format(
                "Coach Details:\n" + "%s" + "- Sport Speciality: %s\n" + "- Hourly Rate: %.2f\n" + "- Availability: %s",
                super.toString(),
                sportType != null ? sportType.name() : "Not Set",
                hourlyRate,
                Arrays.toString(availability)
        );
    }

    public static class CoachBuilder extends Employee.EmployeeBuilder<CoachBuilder>{
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

        @Override
        public Coach build() {
            return new Coach(this);
        }
        @Override
        public CoachBuilder self() {
            return this;
        }

    }
}

package fr.efrei.domain;

import java.util.Arrays;


public class Receptionist extends Employee {
    private static final int MAX_WORKING_HOURS = 8;
    private double hourlyRate;
    private boolean[] workingHours = new boolean[MAX_WORKING_HOURS];

    private Receptionist(){
        super();
    }
    private Receptionist(ReceptionistBuilder builder) {
        super(builder);
        this.hourlyRate = builder.hourlyRate;
        this.workingHours = builder.workingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean[] getWorkingHours() {
        return workingHours;
    }

    @Override
    public String toString() {
        return super.toString() + "Receptionist{" +
                "hourlyRate=" + hourlyRate +
                ", workingHours=" + Arrays.toString(workingHours) +
                '}';
    }

    public static class ReceptionistBuilder extends Employee.EmployeeBuilder {
        private double hourlyRate;
        private boolean[] workingHours = new boolean[MAX_WORKING_HOURS];

        public ReceptionistBuilder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public ReceptionistBuilder setWorkingHours(boolean[] workingHours) {
            this.workingHours = workingHours;
            return this;
        }

        public Receptionist build() {
            return new Receptionist(this);
        }
    }
}

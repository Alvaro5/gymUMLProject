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
        return String.format(
                "Receptionist Details:\n" + "%s" + "- Hourly Rate: %.2f\n" + "- Working Hours: %s",
                super.toString(),
                hourlyRate,
                Arrays.toString(workingHours)
        );
    }

    public static class ReceptionistBuilder extends Employee.EmployeeBuilder<ReceptionistBuilder> {
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

        @Override
        public Receptionist build() {
            return new Receptionist(this);
        }
        @Override
        public ReceptionistBuilder self() {
            return this;
        }    }
}

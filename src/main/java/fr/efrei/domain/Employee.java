package fr.efrei.domain;

public abstract class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;

    private boolean onRestDay;
    private String bankDetails;

    public Employee() {}

    public Employee(EmployeeBuilder<?> builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.onRestDay = builder.onRestDay;
        this.bankDetails = builder.bankDetails;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isOnRestDay() {
        return onRestDay;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", onRestDay=" + onRestDay +
                ", bankDetails='" + bankDetails + '\'' +
                '}';
    }

    public static abstract class EmployeeBuilder<T extends EmployeeBuilder<T>>{
        private int employeeId;
        private String firstName;
        private String lastName;
        private boolean onRestDay;
        private String bankDetails;

        public T setEmployeeId(int id) {
            this.employeeId = employeeId;
            return self();
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return self();
        }
        public T setLastName(String lastName) {
            this.lastName = lastName;
            return self();
        }
        public T setOnRestDay(boolean onRestDay) {
            this.onRestDay = onRestDay;
            return self();
        }
        public T setBankDetails(String bankDetails) {
            this.bankDetails = bankDetails;
            return self();
        }

        public abstract T self();
        public abstract Employee build();

    }
}

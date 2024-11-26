package fr.efrei.domain;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private boolean onRestDay;
    private String bankDetails;

    public Employee() {}

    Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.onRestDay = builder.onRestDay;
        this.bankDetails = builder.bankDetails;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", onRestDay=" + onRestDay +
                ", bankDetails='" + bankDetails + '\'' +
                '}';
    }

    public static class EmployeeBuilder{
        private int id;
        private String firstName;
        private String lastName;
        private boolean onRestDay;
        private String bankDetails;

        public EmployeeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public EmployeeBuilder setOnRestDay(boolean onRestDay) {
            this.onRestDay = onRestDay;
            return this;
        }
        public EmployeeBuilder setBankDetails(String bankDetails) {
            this.bankDetails = bankDetails;
            return this;
        }

        public Employee build() { return new Employee(this); }
    }
}

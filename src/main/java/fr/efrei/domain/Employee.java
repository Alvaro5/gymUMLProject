package fr.efrei.domain;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private boolean inHolydays;
    private String bank_details;

    public Employee(){}
    public Employee(EmployeeBuilder builder) {
        this.id = id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.inHolydays = builder.inHolydays;
        this.bank_details = builder.bank_details;
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

    public boolean isInHolydays() {
        return inHolydays;
    }

    public String getBank_details() {
        return bank_details;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", inHolydays=" + inHolydays +
                ", bank_details='" + bank_details + '\'' +
                '}';
    }

    public static class EmployeeBuilder{
        private int id;
        private String firstName;
        private String lastName;
        private boolean inHolydays;
        private String bank_details;

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
        public EmployeeBuilder setInHolydays(boolean inHolydays) {
            this.inHolydays = inHolydays;
            return this;
        }
        public EmployeeBuilder setBank_details(String bank_details) {
            this.bank_details = bank_details;
            return this;
        }

        public Employee build() { return new Employee(this); }
    }
}

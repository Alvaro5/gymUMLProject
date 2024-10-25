package fr.efrei.domain;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String membershipStatus;

    private Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.membershipStatus = builder.membershipStatus;
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

    public int getAge() {
        return age;
    }

    public String isMembershipStatus() {
        return membershipStatus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", membershipStatus=" + membershipStatus +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String membershipStatus;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setMembershipStatus(String membershipStatus) {
            this.membershipStatus = membershipStatus;
            return this;
        }

        public Customer build() { return new Customer(this); }
    }
}

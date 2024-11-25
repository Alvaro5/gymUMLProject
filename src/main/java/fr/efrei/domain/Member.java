package fr.efrei.domain;

public class Member {
    private int memberID;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private Membership membership;

    private Member() {
    }

    private Member(Builder builder) {
        this.memberID = builder.memberID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.membershipStatus = builder.membershipStatus;
    }

    public int getMemberID() {
        return memberID;
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

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membershipStatus=" + membershipStatus +
                '}';
    }

    public static class Builder {
        private int memberID;
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phoneNumber;
        private MembershipStatus membershipStatus;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMemberID(int memberID) {
            this.memberID = memberID;
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

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setMembershipStatus(MembershipStatus membershipStatus) {
            this.membershipStatus = membershipStatus;
            return this;
        }

        public Builder copy (Member member) {
            this.memberID = member.memberID;
            this.firstName = member.firstName;
            this.lastName = member.lastName;
            this.age = member.age;
            this.email = member.email;
            this.phoneNumber = member.phoneNumber;
            this.membershipStatus = member.membershipStatus;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}

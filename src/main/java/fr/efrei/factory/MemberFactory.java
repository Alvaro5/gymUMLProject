package fr.efrei.factory;

import fr.efrei.domain.Member;
import fr.efrei.domain.Membership;
import fr.efrei.util.Helper;

import java.time.LocalDate;

public class MemberFactory {

    public static Member buildMember(int id, String firstName, String lastName, int age, String email, String phoneNumber, String membershipStatus, String paymentRate, LocalDate startDate, LocalDate endDate) {

        Membership membership = MembershipFactory.buildMembership(membershipStatus, paymentRate, startDate, endDate);

        if (membership == null) {
            System.out.println("Membership is incorrect");
            return null;
        }

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(String.valueOf(id))) {
            System.out.println("Empty member data");
            return null;
        }

        if (Helper.isEmailValid(email) || Helper.isNullOrEmpty(email)) {
            System.out.println("Invalid email");
            return null;
        }

        if (Helper.isPhoneNumberValid(phoneNumber) || Helper.isNullOrEmpty(phoneNumber)) {
            System.out.println("Invalid phone number");
        }

        if (age < 18 || Helper.isNullOrEmpty(String.valueOf(age))) {
            System.out.println("The age is below 18 or is empty");
            return null;
        }

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setMembership(membership)
                .build();
    }

    public static Member buildMember(String firstName, String lastName, int age, String email, String phoneNumber, String membershipStatus, String paymentRate, LocalDate startDate, LocalDate endDate) {

        Membership membership = MembershipFactory.buildMembership(membershipStatus, paymentRate, startDate, endDate);

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            System.out.println("Empty member data");
            return null;
        }

        if (membership == null) {
            System.out.println("Membership is incorrect");
            return null;
        }

        if (Helper.isEmailValid(email) || Helper.isNullOrEmpty(email)) {
            System.out.println("Invalid email");
            return null;
        }

        if (Helper.isPhoneNumberValid(phoneNumber) || Helper.isNullOrEmpty(phoneNumber)) {
            System.out.println("Invalid phone number");
        }

        if (age < 18 || Helper.isNullOrEmpty(String.valueOf(age))) {
            System.out.println("The age is below 18 or is empty");
            return null;
        }

        int id = Helper.generateId();

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setMembership(membership)
                .build();
    }
}

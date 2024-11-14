package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(int id, String firstName, String lastName, int age, String membershipStatus) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(String.valueOf(id))) {
            return null;
        }

        return new Customer.Builder().setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setMembershipStatus(membershipStatus)
                .build();
    }

    public static Customer buildCustomer(String firstName, String lastName, int age, String membershipStatus) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            return null;
        }

        int id = Helper.generateId();

        return new Customer.Builder().setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setMembershipStatus(membershipStatus)
                .build();
    }
}

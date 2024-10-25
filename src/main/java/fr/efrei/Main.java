package fr.efrei;

import fr.efrei.domain.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer.Builder().setFirstName("Alvaro")
                .setLastName("Serero")
                .setAge(19)
                .setId(1)
                .setMembershipStatus("active")
                .build();

        System.out.println(customer.toString());
    }
}

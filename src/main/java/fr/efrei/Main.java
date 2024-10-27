package fr.efrei;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Session;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer.Builder().setFirstName("Alvaro")
                .setLastName("Serero")
                .setAge(19)
                .setId(1)
                .setMembershipStatus("active")
                .build();

        System.out.println(customer.toString());

        Session session = new Session.Builder()
                .setCoach(true)
                .setSport("spin")
                .setDate("27-10-2024")
                .setTime("10:00")
                .build();

        boolean addCust = session.addCustomer(customer);
        System.out.println(session.toString());
    }
}

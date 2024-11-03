package fr.efrei;

import fr.efrei.domain.Coach;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Employee;
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

        Employee employee = new Employee.EmployeeBuilder().setBank_details("RIB")
                .setInHolydays(false)
                .setFirstName("Anne-Laure")
                .setLastName("Parguet")
                .setId(123)
                .build();

        System.out.println(employee.toString());

        Coach coach = (Coach) new Coach.CoachBuilder().setAvailability(null)
                .setWorkingHours("10h-18h")
                .setBank_details("RIB")
                .setInHolydays(true)
                .setId(456)
                .setFirstName("Lea")
                .setLastName("Petit")
                .build();

        System.out.println(coach.toString());
    }
}

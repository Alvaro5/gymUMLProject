package fr.efrei;

import fr.efrei.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Member member1 = new Member.Builder().setMemberID(1)
                .setFirstName("Alvaro")
                .setLastName("Serero")
                .setAge(19)
                .setEmail("alvaroserero@gmail.com")
                .setPhoneNumber("+33 7 62 94 72 84")
                .setMembershipStatus(Member.MembershipStatus.ACTIVE)
                .build();

        System.out.println(member1);

        Member member2 = new Member.Builder().setMemberID(2)
                .setFirstName("Blandine")
                .setLastName("Lecry")
                .setAge(20)
                .setEmail("blandine@gmail.com")
                .setPhoneNumber("+33 7 23 53 90 54")
                .setMembershipStatus(Member.MembershipStatus.EXPIRED)
                .build();

        System.out.println(member2);

        Session session = new Session.Builder()
                .setCoach(true)
                .setSport("spin")
                .setDate(LocalDate.parse("27-10-2024"))
                .setTime(LocalTime.parse("10:00"))
                .build();

        boolean addCust = session.addMember(member1);
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

        Receptionist receptionist = (Receptionist) new Receptionist.ReceptionistBuilder().setHourlyRate(18.23)
                .setWorkingHours(null)
                .setBank_details("RIB")
                .setInHolydays(false)
                .setFirstName("Anna")
                .setId(789)
                .setLastName("io")
                .build();

        System.out.println(receptionist.toString());
    }
}

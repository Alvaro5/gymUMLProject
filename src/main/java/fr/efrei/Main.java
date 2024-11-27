package fr.efrei;

import fr.efrei.domain.*;
import fr.efrei.factory.MemberFactory;
import fr.efrei.repository.IMemberRepository;
import fr.efrei.repository.MemberRepository;
import fr.efrei.views.MemberView;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Testing of the Member class and its Builder
        Member member1 = new Member.Builder().setMemberID(1)
                .setFirstName("Alvaro")
                .setLastName("Serero")
                .setAge(19)
                .setEmail("alvaroserero@gmail.com")
                .setPhoneNumber("+33 7 62 94 72 84")
                .setMembership(
                        new Membership.Builder().setMembershipStatus(Membership.MembershipStatus.ACTIVE)
                            .setEndDate(LocalDate.now().plusDays(1))
                            .setStartDate(LocalDate.now())
                            .setPaymentRate(Membership.PaymentRate.DAILY)
                            .build()
                )
                .build();

        System.out.println(member1);

        Member member2 = new Member.Builder().setMemberID(2)
                .setFirstName("Blandine")
                .setLastName("Lecry")
                .setAge(20)
                .setEmail("blandine@gmail.com")
                .setPhoneNumber("+33 7 23 53 90 54")
                .setMembership(
                        new Membership.Builder().setMembershipStatus(Membership.MembershipStatus.EXPIRED)
                                .setEndDate(LocalDate.now().plusDays(1))
                                .setStartDate(LocalDate.now())
                                .setPaymentRate(Membership.PaymentRate.DAILY)
                                .build()
                )
                .build();

        System.out.println(member2);


        // Testing of the MemberFactory class
        LocalDate today = LocalDate.now();
        LocalDate inAMonth = LocalDate.now().plusDays(30);
        Member member3 = MemberFactory.buildMember(3, "Alvaro", "Serero", 20, "alvaroserero@gmail.com", "+33 7 62 94 72 84", "inactive", "monthly", today, inAMonth);
        System.out.println(member3);

        // Testing of the MemberRepository class
        IMemberRepository memberRepository = MemberRepository.getRepository();

        /*
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

        System.out.println(receptionist.toString());*/

        // Main menu

        // Instantiation of the repository and views classes
        IMemberRepository memberRepository2 = MemberRepository.getRepository();
        MemberView memberView = new MemberView(memberRepository2);

        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select an option:");
            System.out.println("1. Member menu");
            System.out.println("2. Employee menu");
            System.out.println("3. Session menu");
            System.out.println("4. Exit\n");

            choice = sc.nextLine();

            switch (choice) {
                case "1": memberView.memberMenu(); break;
                case "2": break;
                case "3": break;
                case "4": break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("4"));
    }
}

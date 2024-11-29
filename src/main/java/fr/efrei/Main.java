package fr.efrei;

import fr.efrei.domain.*;
import fr.efrei.factory.*;
import fr.efrei.repository.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Testing of the Member class
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
        System.out.println(memberRepository.getAll());

        // Testing of the Coach and Receptionist classes
        Coach coach = new Coach.CoachBuilder().setAvailability(null)
                .setHourlyRate(20.0)
                .setSportType(Coach.SportType.YOGA)
                .setBankDetails("RIB")
                .setOnRestDay(true)
                .setEmployeeId(456)
                .setFirstName("Lea")
                .setLastName("Petit")
                .build();

        System.out.println(coach);

        Receptionist receptionist = new Receptionist.ReceptionistBuilder().setHourlyRate(18.23)
                .setWorkingHours(null)
                .setBankDetails("RIB")
                .setOnRestDay(true)
                .setFirstName("Anna")
                .setEmployeeId(2)
                .setLastName("io")
                .build();

        System.out.println(receptionist);

        // Testing of Coach and Receptionist factory classes
        boolean[] availability = new boolean[]{true, true, true, true, true};
        Coach coach2 = CoachFactory.buildCoach(5, "Serero", "Alvaro", true, "FBSDFBDBFVDFSVDSFEZ", "weightlifting", 28.00, availability);
        System.out.println(coach2);

        boolean[] workingHours = new boolean[]{true, true, true, true, true};
        Receptionist receptionist2 = ReceptionistFactory.buildReceptionist(6, "Serero", "Alvaro", true, "SVDUYQVSDUYDVYUQSVDUYDVS", 15.00, workingHours);
        System.out.println(receptionist2);

        // Testing of Coach and Receptionist repository classes
        ICoachRepository coachRepository = CoachRepository.getRepository();
        IReceptionistRepository receptionistRepository = ReceptionistRepository.getRepository();

        // Test create method
        System.out.println("Creating Receptionists...");
        receptionistRepository.create(receptionist);
        receptionistRepository.create(receptionist2);

        System.out.println("Creating Coaches...");
        coachRepository.create(coach);
        coachRepository.create(coach2);

        // Test read method
        System.out.println();
        System.out.println("Reading receptionist with ID 6");
        System.out.println(receptionistRepository.read(6));

        System.out.println();
        System.out.println("Reading coach with ID 5");
        System.out.println(coachRepository.read(5));

        // Test update method
        System.out.println();
        System.out.println("Updating Receptionist with ID 6:");
        Receptionist updatedReceptionist = ReceptionistFactory.buildReceptionist(6, "Smith", "Alice", true, "FKDHJBGSIFUBZFIUZAG", 13.00, workingHours);
        receptionistRepository.update(updatedReceptionist);
        System.out.println(receptionistRepository.read(6));

        System.out.println();
        System.out.println("Updating Coach with ID 5:");
        Coach updatedCoach = CoachFactory.buildCoach(5, "Smith", "William", false, "FEZIUDBIEZBDINEZJKDNKAZBDKU", "running", 26.00, workingHours);
        coachRepository.update(updatedCoach);
        System.out.println(coachRepository.read(5));

        // Test delete method
        System.out.println("\nDeleting Receptionist with ID 6:");
        boolean receptionistDelete = receptionistRepository.delete(6);
        System.out.println(receptionistDelete);

        System.out.println("\nDeleting Coach with ID 5:");
        boolean coachDelete = coachRepository.delete(5);
        System.out.println(coachDelete);

        // Test getAll method
        System.out.println("\nPrinting all Receptionists:");
        System.out.println(receptionistRepository.getAll());

        System.out.println("\nPrinting all Coaches:");
        System.out.println(coachRepository.getAll());


        // Testing of the Session class
        List<Member> members = new ArrayList<>();
        members.add(member1);
        members.add(member2);
        members.add(member3);

        Session session1 = new Session.Builder().setSessionID(1)
                .setSportType(Session.SportType.BOXING)
                .setDate(LocalDate.now())
                .setTime(LocalTime.now())
                .setCoach(coach)
                .setReceptionist(receptionist)
                .setListMembers(members)
                .build();

        System.out.println("\n" + session1);

        // Testing of the SessionFactory class
        List<Member> members2 = new ArrayList<>();
        members2.add(member1);
        members2.add(member2);
        Session session2 = SessionFactory.buildSession(2, "spinning", LocalDate.now(), LocalTime.now(), coach2, receptionist2, members2);
        System.out.println("\n" + session2);

        // Testing of the SessionRepository class
        ISessionRepository sessionRepository = SessionRepository.getRepository();
        System.out.println(sessionRepository.getAll());
    }
}

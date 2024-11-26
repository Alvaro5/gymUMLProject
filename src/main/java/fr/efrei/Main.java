package fr.efrei;

import fr.efrei.domain.*;
import fr.efrei.factory.MemberFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

        // Testing of the Session class

        List<Member> listMembersSession = new ArrayList<>();
        listMembersSession.add(member1);
        listMembersSession.add(member2);
        listMembersSession.add(member3);

        Boolean[] workingHours = new Boolean[8];

        Receptionist receptionist = new Receptionist.ReceptionistBuilder()
                .setId(1)
                .setBankDetails("P")
                .setFirstName("sdfe")
                .setLastName("sdfs")
                .setOnRestDay(true)
                .setHourlyRate(11.00)
                .setWorkingHours(workingHours)
                .build();

        Coach coach = new Coach.CoachBuilder()
                .setId(1)
                .setBankDetails("P")
                .setFirstName("sdfe")
                .setLastName("sdfs")
                .setOnRestDay(false)
                .setHourlyRate(35.00)
                .build();

        Session session = new Session.Builder()
                .setSessionID(1)
                .setSportType(Session.SportType.BOXING)
                .setDate(LocalDate.now())
                .setTime(LocalTime.now())
                .setCoach(coach)
                .setReceptionist(receptionist)
                .setListMembers(listMembersSession)
                .build();

        System.out.println(session);

        /*boolean addCust = session.addMember(member1);
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
    }
}

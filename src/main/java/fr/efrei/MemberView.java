package fr.efrei.views;

import fr.efrei.domain.Member;
import fr.efrei.domain.Membership;
import fr.efrei.factory.MemberFactory;
import fr.efrei.repository.IMemberRepository;
import fr.efrei.repository.MemberRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    private static IMemberRepository memberRepository;

    public MemberView() {}

    public MemberView(IMemberRepository memberRepository) {
        MemberView.memberRepository = memberRepository;
    }

    public static void createMember() {
        Scanner sc = new Scanner(System.in);
        int id, age;
        String firstName, lastName, email, phoneNumber, membershipStatus, paymentRate;
        LocalDate startDate, endDate;

        System.out.println("Please enter the following information.");
        System.out.println("Member ID: ");
        id = sc.nextInt();
        System.out.println("Member Age: ");
        age = sc.nextInt();
        System.out.println("Member First Name: ");
        firstName = sc.next();
        System.out.println("Member Last Name: ");
        lastName = sc.next();
        System.out.println("Member Email: ");
        email = sc.next();
        System.out.println("Member Phone Number: ");
        phoneNumber = sc.next();
        System.out.println("Membership Status: ");
        membershipStatus = sc.next();
        System.out.println("Payment Rate: ");
        paymentRate = sc.next();
        System.out.println("Membership Start Date: ");
        startDate = LocalDate.parse(sc.next());
        System.out.println("Membership End Date: ");
        endDate = LocalDate.parse(sc.next());

        Member member = MemberFactory.buildMember(id, firstName, lastName, age, email, phoneNumber, membershipStatus, paymentRate, startDate, endDate);
        if (member != null) {
            memberRepository.create(member);
        } else {
            System.out.println("Member not created");
        }
    }

    private static void readMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Member ID: ");
        int id = sc.nextInt();

    }

    public static void updateMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Member ID: ");
        deleteMember();
    }

    public static void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Member ID: ");
        int id = sc.nextInt();
        memberRepository.delete(id);
    }

    public static void showMembers() {
        List<Member> memberList = memberRepository.getAll();

        System.out.println("List of Members: ");
        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    public void memberMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select an option:");
            System.out.println("1. Create Member");
            System.out.println("2. Read Member");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Show all Members");
            System.out.println("6. Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1": createMember(); break;
                case "2": readMember(); break;
                case "3": updateMember(); break;
                case "4": deleteMember(); break;
                case "5": showMembers(); break;
                case "6": break;
                default:
                    System.out.println("Invalid option");;

            }
        } while (!choice.equals("6"));
    }

}

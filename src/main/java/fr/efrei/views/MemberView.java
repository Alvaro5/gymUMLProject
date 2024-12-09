package fr.efrei.views;

import fr.efrei.domain.Member;
import fr.efrei.domain.Membership;
import fr.efrei.factory.MemberFactory;
import fr.efrei.repository.IMemberRepository;

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
        // Define scanner and input variables
        Scanner sc = new Scanner(System.in);
        int id, age;
        String firstName, lastName, email, phoneNumber, membershipStatus, paymentRate;
        LocalDate startDate, endDate;

        // Scan inputs from the user
        System.out.println("\nPlease enter the following information...");
        System.out.print("Member ID: ");
        id = sc.nextInt();
        System.out.print("Member Age: ");
        age = sc.nextInt();
        System.out.print("Member First Name: ");
        firstName = sc.next();
        System.out.print("Member Last Name: ");
        lastName = sc.next();
        System.out.print("Member Email: ");
        email = sc.next();
        System.out.print("Member Phone Number: ");
        phoneNumber = sc.next();
        System.out.print("Membership Status: ");
        membershipStatus = sc.next();
        System.out.print("Payment Rate: ");
        paymentRate = sc.next();

        sc.nextLine();

        while (true) {
            try {
                System.out.print("Membership Start Date (in the form YYYY-MM-DD): ");
                startDate = LocalDate.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Membership End Date (in the form YYYY-MM-DD): ");
                endDate = LocalDate.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        // Create new member from given information
        Member member = MemberFactory.buildMember(id, firstName, lastName, age, email, phoneNumber, membershipStatus, paymentRate, startDate, endDate);

        // Add the new member to the repository if it was created successfully
        if (member != null) {
            memberRepository.create(member);
            System.out.println("\nMember created!");
            System.out.println(member);
        } else {
            System.out.println("\nMember not created!");
        }
    }

    public static void readMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Member ID: ");
        int id = sc.nextInt();

        Member readMember = memberRepository.read(id);

        if (readMember != null) {
            System.out.println("\n" + readMember);
        } else {
            System.out.println("\nMember not found!");
        }
    }

    public static void updateMember() {
        // Prompt the user to enter the ID of the member to update
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Member ID: ");
        int id = sc.nextInt();

        // Retrieve the member having the given ID
        Member currentMember = memberRepository.read(id);
        Membership currentMembership = currentMember.getMembership();

        if (currentMember != null) {
            // Show current member details
            System.out.println("\nCurrent Member details:");
            System.out.println(currentMember);

            // Input new member details
            System.out.println("\nEnter new details (leave blank to keep current value):");
            sc.nextLine(); // Consume leftover newline

            System.out.println("First Name (" + currentMember.getFirstName() + "): ");
            String firstName = sc.nextLine();
            if (firstName.isEmpty()) {
                firstName = currentMember.getFirstName();
            }

            System.out.println("Last Name (" + currentMember.getLastName() + "): ");
            String lastName = sc.nextLine();
            if (lastName.isEmpty()) {
                lastName = currentMember.getLastName();
            }

            System.out.println("Age (" + currentMember.getAge() + "): ");
            String ageInput = sc.nextLine();
            int age = ageInput.isEmpty() ? currentMember.getAge() : Integer.parseInt(ageInput);

            System.out.println("Email (" + currentMember.getEmail() + "): ");
            String email = sc.nextLine();
            if (email.isEmpty()) {
                email = currentMember.getEmail();
            }

            System.out.println("Phone Number (" + currentMember.getPhoneNumber() + "): ");
            String phoneNumber = sc.nextLine();
            if (phoneNumber.isEmpty()) {
                phoneNumber = currentMember.getPhoneNumber();
            }

            System.out.println("Membership Status (" + currentMembership.getMembershipStatus() + "): ");
            String membershipStatus = sc.nextLine();
            if (membershipStatus.isEmpty()) {
                membershipStatus = String.valueOf(currentMembership.getMembershipStatus());
            }

            System.out.println("Payment Rate (" + currentMembership.getPaymentRate() + "): ");
            String paymentRate = sc.nextLine();
            if (paymentRate.isEmpty()) {
                paymentRate = String.valueOf(currentMembership.getPaymentRate());
            }

            System.out.println("Membership Start Date (" + currentMembership.getStartDate() + "): ");
            String startDateInput = sc.nextLine();
            LocalDate startDate = startDateInput.isEmpty() ? currentMembership.getStartDate() : LocalDate.parse(startDateInput);

            System.out.println("Membership End Date (" + currentMembership.getEndDate() + "): ");
            String endDateInput = sc.nextLine();
            LocalDate endDate = endDateInput.isEmpty() ? currentMembership.getEndDate() : LocalDate.parse(endDateInput);

            // Create the updated member
            Member newMember = MemberFactory.buildMember(id, firstName, lastName, age, email, phoneNumber, membershipStatus, paymentRate, startDate, endDate);

            // Update repository with updated member
            Member result = memberRepository.update(newMember);

            // Check member update
            if (result != null) {
                System.out.println("\nMember updated!");
                System.out.println(result);
            } else {
                System.out.println("\nMember not updated!");
            }
        } else {
            System.out.println("\nMember not found!");
        }



    }

    public static void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Member ID: ");
        int id = sc.nextInt();

        // Delete member with given ID
        boolean deletionFlag = memberRepository.delete(id);

        // Notify user of successful member deletion
        if (deletionFlag) {
            System.out.println("\nMember deleted!");
        } else {
            System.out.println("\nMember not found!");
        }
    }

    public static void showMembers() {
        List<Member> memberList = memberRepository.getAll();

        System.out.println("\nList of Members: ");
        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    public void memberMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Member");
            System.out.println("2. Read Member");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Show all Members");
            System.out.println("6. Exit\n");
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
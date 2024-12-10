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
        sc.nextLine();
        System.out.print("Member Age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Member First Name: ");
        firstName = sc.nextLine();
        System.out.print("Member Last Name: ");
        lastName = sc.nextLine();
        System.out.print("Member Email: ");
        email = sc.nextLine();
        System.out.print("Member Phone Number: ");
        phoneNumber = sc.nextLine();
        System.out.print("Membership Status (ACTIVE, SUSPENDED, PENDING, INACTIVE, EXPIRED or CANCELLED): ");
        membershipStatus = sc.nextLine();
        System.out.print("Payment Rate (DAILY, MONTHLY or YEARLY): ");
        paymentRate = sc.nextLine();

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
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Member ID: ");
        int id = sc.nextInt();

        // Retrieve the member by ID
        Member currentMember = memberRepository.read(id);

        if (currentMember == null) {
            System.out.println("\nMember not found!");
            return;
        }

        Membership currentMembership = currentMember.getMembership();

        System.out.println("\nCurrent Member details:");
        System.out.println(currentMember);

        // Input new details, preserving existing values when no input is given
        sc.nextLine(); // Consume the newline character

        System.out.print("First Name (" + currentMember.getFirstName() + "): ");
        String firstName = sc.nextLine();
        firstName = firstName.isEmpty() ? currentMember.getFirstName() : firstName;

        System.out.print("Last Name (" + currentMember.getLastName() + "): ");
        String lastName = sc.nextLine();
        lastName = lastName.isEmpty() ? currentMember.getLastName() : lastName;

        System.out.print("Age (" + currentMember.getAge() + "): ");
        String ageInput = sc.nextLine();
        int age = ageInput.isEmpty() ? currentMember.getAge() : Integer.parseInt(ageInput);

        System.out.print("Email (" + currentMember.getEmail() + "): ");
        String email = sc.nextLine();
        email = email.isEmpty() ? currentMember.getEmail() : email;

        System.out.print("Phone Number (" + currentMember.getPhoneNumber() + "): ");
        String phoneNumber = sc.nextLine();
        phoneNumber = phoneNumber.isEmpty() ? currentMember.getPhoneNumber() : phoneNumber;

        System.out.print("Membership Status (" + currentMembership.getMembershipStatus() + "): ");
        String membershipStatus = sc.nextLine();
        membershipStatus = membershipStatus.isEmpty() ? currentMembership.getMembershipStatus().name() : membershipStatus;

        System.out.print("Payment Rate (" + currentMembership.getPaymentRate() + "): ");
        String paymentRate = sc.nextLine();
        paymentRate = paymentRate.isEmpty() ? currentMembership.getPaymentRate().name() : paymentRate;

        LocalDate startDate;
        while (true) {
            System.out.print("Membership Start Date (" + currentMembership.getStartDate() + "): ");
            String startDateInput = sc.nextLine();
            if (startDateInput.isEmpty()) {
                startDate = currentMembership.getStartDate();
                break;
            }
            try {
                startDate = LocalDate.parse(startDateInput);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        LocalDate endDate;
        while (true) {
            System.out.print("Membership End Date (" + currentMembership.getEndDate() + "): ");
            String endDateInput = sc.nextLine();
            if (endDateInput.isEmpty()) {
                endDate = currentMembership.getEndDate();
                break;
            }
            try {
                endDate = LocalDate.parse(endDateInput);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        // Build updated member and update repository
        Member updatedMember = MemberFactory.buildMember(
                id, firstName, lastName, age, email, phoneNumber, membershipStatus, paymentRate, startDate, endDate
        );

        if (updatedMember == null) {
            System.out.println("\nFailed to update member. Invalid data provided.");
            return;
        }

        Member result = memberRepository.update(updatedMember);
        if (result != null) {
            System.out.println("\nMember updated!");
            System.out.println(result);
        } else {
            System.out.println("\nMember not updated!");
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
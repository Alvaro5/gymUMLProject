package fr.efrei.views;

import fr.efrei.domain.Coach;
import fr.efrei.domain.Member;
import fr.efrei.domain.Receptionist;
import fr.efrei.domain.Session;
import fr.efrei.factory.CoachFactory;
import fr.efrei.factory.ReceptionistFactory;
import fr.efrei.factory.SessionFactory;
import fr.efrei.repository.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SessionView {
    private static ISessionRepository sessionRepository;

    public SessionView() {}
    public SessionView(ISessionRepository sessionRepository){
        SessionView.sessionRepository = sessionRepository;
    }

    public static void createSession() {
        Scanner sc = new Scanner(System.in);
        int sessionId, coachId, receptionistId;
        String sportType;
        LocalDate date;
        LocalTime time;

        System.out.println("\nPlease enter the following information...");
        System.out.println("Session ID: ");
        sessionId = sc.nextInt();
        System.out.println("Sport type: ");
        sportType = sc.next();

        sc.nextLine();

        while (true) {
            try {
                System.out.print("Session Date (in the form YYYY-MM-DD): ");
                date = LocalDate.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Session Time (in the form HH:MM:SS): ");
                time = LocalTime.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid time format. Try again.");
            }
        }

        System.out.println("Coach ID: ");
        coachId = sc.nextInt();
        System.out.println("Receptionist ID: ");
        receptionistId = sc.nextInt();

        Coach coach = CoachRepository.getRepository().read(coachId);
        Receptionist receptionist = ReceptionistRepository.getRepository().read(receptionistId);

        List<Member> members = new ArrayList<>();
        System.out.print("\nHow many members would you like to add? (Max: 5): ");
        int numMembers;
        while (true) {
            numMembers = sc.nextInt();
            if (numMembers > 0 && numMembers <= 5) {
                break;
            } else {
                System.out.print("Invalid number of members. Please enter a number between 1 and 5: ");
            }
        }

        for (int i = 0; i < numMembers; i++) {
            System.out.print("Enter ID for member " + (i + 1) + ": ");
            int memberID = sc.nextInt();
            Member existingMember = MemberRepository.getRepository().read(memberID);
            if (existingMember != null) {
                members.add(existingMember);
            } else {
                System.out.println("Member not found. Skipping.");
            }
        }

        Session session = SessionFactory.buildSession(sessionId, sportType, date, time, coach, receptionist, members);

        if (session != null){
            sessionRepository.create(session);
            System.out.println("Session created!");
        } else {
            System.out.println("Session not created!");
        }
    }

    public static void readSession() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Session ID: ");
        int id = sc.nextInt();

        Session readSession = sessionRepository.read(id);
        if (readSession != null) {
            System.out.println("\n" + readSession);
        } else {
            System.out.println("\nSession not found!");
        }
    }

    public static void updateSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Session ID to update: ");
        int id = sc.nextInt();

        Session currentSession = sessionRepository.read(id);
        if (currentSession != null) {
            System.out.println("\nCurrent session: " + currentSession);
            Session.Builder sessionBuilder = new Session.Builder().copy(currentSession);
            String choice;

            do {
                System.out.println("\nWhat would you like to update?");
                System.out.println("1. Sport Type");
                System.out.println("2. Session Date");
                System.out.println("3. Session Time");
                System.out.println("4. Coach");
                System.out.println("5. Receptionist");
                System.out.println("6. Members");
                System.out.println("7. Exit Update\n");
                choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("\nEnter new sport type from the list below: ");
                        for (Session.SportType sportType : Session.SportType.values()) {
                            System.out.println("- " + sportType);
                        }

                        try {
                            String newSportType = sc.nextLine();
                            Session.SportType sportType = Session.SportType.valueOf(newSportType.toUpperCase());
                            sessionBuilder.setSportType(sportType);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid sport type. Try again.");
                        }
                        break;
                    case "2":
                        while (true) {
                            try {
                                System.out.print("\nEnter new Session Date (YYYY-MM-DD): ");
                                LocalDate newDate = LocalDate.parse(sc.nextLine());
                                sessionBuilder.setDate(newDate);
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            try {
                                System.out.print("\nEnter new Session Time (HH:MM:SS): ");
                                LocalTime newTime = LocalTime.parse(sc.nextLine());
                                sessionBuilder.setTime(newTime);
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid time format. Please try again.");
                            }
                        }
                        break;
                    case "4":
                        System.out.print("\nEnter new Coach ID: ");
                        int newCoachId = sc.nextInt();
                        sc.nextLine(); // Consume newline character
                        Coach newCoach = CoachRepository.getRepository().read(newCoachId);
                        if (newCoach != null) {
                            sessionBuilder.setCoach(newCoach);
                        } else {
                            System.out.println("Coach not found.");
                        }
                        break;
                    case "5":
                        System.out.print("\nEnter new Receptionist ID: ");
                        int newReceptionistId = sc.nextInt();
                        sc.nextLine(); // Consume newline character
                        Receptionist newReceptionist = ReceptionistRepository.getRepository().read(newReceptionistId);
                        if (newReceptionist != null) {
                            sessionBuilder.setReceptionist(newReceptionist);
                        } else {
                            System.out.println("Receptionist not found.");
                        }
                        break;
                    case "6":
                        System.out.print("\nHow many members would you like to add/replace? (Max: 5): ");
                        int numMembers;
                        while (true) {
                            numMembers = sc.nextInt();
                            sc.nextLine(); // Consume newline character
                            if (numMembers >= 0 && numMembers <= 5) {
                                break;
                            } else {
                                System.out.print("Invalid number of members. Please enter a number between 0 and 5: ");
                            }
                        }

                        List<Member> updatedMembers = new ArrayList<>();
                        for (int i = 0; i < numMembers; i++) {
                            System.out.print("Enter ID for member " + (i + 1) + ": ");
                            int memberID = sc.nextInt();
                            sc.nextLine(); // Consume newline character
                            Member member = MemberRepository.getRepository().read(memberID);
                            if (member != null) {
                                updatedMembers.add(member);
                            } else {
                                System.out.println("Member not found. Skipping.");
                            }
                        }
                        sessionBuilder.setListMembers(updatedMembers);
                        break;
                    case "7":
                        System.out.println("\nExiting update.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (!choice.equals("7"));

            Session updatedSession = sessionBuilder.build();
            sessionRepository.update(updatedSession);
            System.out.println("\nSession updated!");
            System.out.println("\n" + updatedSession);
        } else {
            System.out.println("\nSession not found!");
        }
    }

    public static void deleteSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Session ID: ");
        int id = sc.nextInt();

        boolean deletionFlag = sessionRepository.delete(id);
        if (deletionFlag) {
            System.out.println("\nSession successfully deleted!");
        } else {
            System.out.println("\nSession not found!");
        }
    }

    public static void showSession(){
        List<Session> sessionList = sessionRepository.getAll();

        System.out.println("\nList of Session: ");
        for (Session session : sessionList){
            System.out.println(session);
        }
    }

    public void sessionMenu(){
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSelect an option: ");
            System.out.println("1. Create Session");
            System.out.println("2. Read Session");
            System.out.println("3. Update Session");
            System.out.println("4. Delete Session");
            System.out.println("5. Show all Session");
            System.out.println("6. Exit\n");
            choice = sc.nextLine();

            switch (choice){
                case "1": createSession(); break;
                case "2": readSession(); break;
                case "3": updateSession(); break;
                case "4": deleteSession(); break;
                case "5": showSession(); break;
                case "6": break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("6"));
    }
}



package fr.efrei.views;

import fr.efrei.domain.Member;
import fr.efrei.domain.Session;
import fr.efrei.factory.SessionFactory;
import fr.efrei.repository.ISessionRepository;

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

    public static void createSession(){
        Scanner sc = new Scanner(System.in);
        int id;
        String sportType, coach, receptionist;
        LocalDate date;
        LocalTime time;
        List<Member> members = new ArrayList<>();

        System.out.println("Please enter the following information.");
        System.out.println("Session ID: ");
        id = sc.nextInt();
        System.out.println("Sport type: ");
        sportType = sc.next();
        System.out.println("Date: ");
        date = LocalDate.parse(sc.next());
        System.out.println("Time: ");
        time = LocalTime.parse(sc.next());
        System.out.println("Coach: ");
        coach = sc.next();
        System.out.println("Receptionist: ");
        receptionist = sc.next();
        for (int i = 0; i < members.size(); i++) {
            int memberID;
            System.out.println("Enter ID for memer " + (i+1));
            memberID = sc.nextInt();

        }



        Session session = SessionFactory.buildSession(id, sportType, date, time, coach, receptionist, );
        if (session != null){
            sessionRepository.create(session);
        }else {
            System.out.println("Session nor created");
        }
    }

    public static void readSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Session ID: ");
        int id = sc.nextInt();
    }

    public static void updateSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Session ID: ");
        deleteSession();
    }

    public static void deleteSession(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Session ID: ");
        int id = sc.nextInt();
        sessionRepository.delete(id);
    }

    public static void showSession(){
        List<Session> sessionList = sessionRepository.getAll();

        System.out.println("List of Session: ");
        for (Session session : sessionList){
            System.out.println(session);
        }
    }

    public void sessionMenu(){
        String choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Select an option: ");
            System.out.println("1. Create Session");
            System.out.println("2. Read Session");
            System.out.println("3. Update Session");
            System.out.println("4. Delete Session");
            System.out.println("5. Show all Session");
            System.out.println("6. Exit");
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
        }while (!choice.equals("6"));
    }
}



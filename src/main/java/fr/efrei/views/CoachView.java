package fr.efrei.views;

import fr.efrei.domain.Coach;
import fr.efrei.factory.CoachFactory;
import fr.efrei.repository.ICoachRepository;

import java.util.List;
import java.util.Scanner;

public class CoachView {
    private static ICoachRepository coachRepository;

    public CoachView() {}

    public CoachView(ICoachRepository coachRepository) {
        CoachView.coachRepository = coachRepository;
    }

    public static void createCoach() {
        Scanner sc = new Scanner(System.in);
        int employeeId;
        String lastName;
        String firstName;
        boolean onRestDay;
        String bankDetails;
        String sportType;
        double hourlyRate;
        boolean[] availability;

        System.out.println("Please enter the following information.");
        System.out.println("Employee ID: ");
        employeeId = sc.nextInt();
        System.out.println("Member Last Name: ");
        lastName = sc.next();
        System.out.println("Member First Name: ");
        firstName = sc.next();
        System.out.println("On rest day (yes or no): ");
        onRestDay = Boolean.parseBoolean(sc.next());
        System.out.println("Bank details: ");
        bankDetails = sc.next();
        System.out.println("Sport type: ");
        sportType = sc.next();
        System.out.println("Hourly rate: ");
        hourlyRate = Double.parseDouble(sc.next());
        System.out.println("Avaibility: ");
        for (boolean b : availability = new boolean[] { Boolean.parseBoolean(sc.next()) });

        Coach coach = CoachFactory.buildCoach(sportType, hourlyRate, availability, employeeId, lastName, firstName, onRestDay, bankDetails);
            if (coach != null) {
                 coachRepository.create(coach);
            } else {
                System.out.println("Coach not created");

        }
    }

    private static void readCoach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Coach ID: ");
        int id = sc.nextInt();
    }

    private static void updateCoach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Coach ID: ");
        deleteCoach();
    }

    private static void deleteCoach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Coach ID: ");
        int id = sc.nextInt();
        coachRepository.delete(id);
    }

    public static void showCoaches() {
        List<Coach> coachList = coachRepository.getAll();

        System.out.println("List of Coaches: ");
        for (Coach coach : coachList) {
            System.out.println(coach);
        }
    }

    public void coachMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select an option:");
            System.out.println("1. Create Coach");
            System.out.println("2. Read Coach");
            System.out.println("3. Update Coach");
            System.out.println("4. Delete Coach");
            System.out.println("5. Show all Coaches");
            System.out.println("6. Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    createCoach();
                    break;
                case "2":
                    readCoach();
                    break;
                case "3":
                    updateCoach();
                    break;
                case "4":
                    deleteCoach();
                    break;
                case "5":
                    showCoaches();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("6"));
    }
}


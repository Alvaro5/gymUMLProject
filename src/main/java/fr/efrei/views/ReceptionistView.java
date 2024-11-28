package fr.efrei.views;

import fr.efrei.domain.Receptionist;
import fr.efrei.factory.ReceptionistFactory;
import fr.efrei.repository.IReceptionistRepository;

import java.util.List;
import java.util.Scanner;

public class ReceptionistView {
    private static IReceptionistRepository receptionistRepository;

    public ReceptionistView() {}

    public ReceptionistView(IReceptionistRepository receptionistRepository) {
        ReceptionistView.receptionistRepository = receptionistRepository;
    }

    public static void createReceptionist() {
        Scanner sc = new Scanner(System.in);
        int employeeId;
        String lastName;
        String firstName;
        boolean onRestDay;
        String bankDetails;
        double hourlyRate;
        boolean[] workingHours ;

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
        System.out.println("Hourly rate: ");
        hourlyRate = Double.parseDouble(sc.next());
        System.out.println("Working hours: ");
        for (boolean b : workingHours = new boolean[] { Boolean.parseBoolean(sc.next()) });

        Receptionist receptionist = ReceptionistFactory.buildReceptionist(hourlyRate,workingHours, employeeId,lastName, firstName, onRestDay, bankDetails);
        if (receptionist != null) {
            receptionistRepository.create(receptionist);
        } else {
            System.out.println("Receptionist not created");

        }
    }

    private static void readReceptionist(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receptionist ID: ");
        int id = sc.nextInt();
    }

    private static void updateReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receptionist ID: ");
        deleteReceptionist();
    }

    private static void deleteReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receptionist ID: ");
        int id = sc.nextInt();
        receptionistRepository.delete(id);
    }

    public static void showReceptionist() {
        List<Receptionist> receptionistList = receptionistRepository.getAll();

        System.out.println("List of Receptionists: ");
        for (Receptionist receptionist : receptionistList) {
            System.out.println(receptionist);
        }
    }

    public void receptionistMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select an option:");
            System.out.println("1. Create Receptionist");
            System.out.println("2. Read Receptionist");
            System.out.println("3. Update Receptionist");
            System.out.println("4. Delete Receptionist");
            System.out.println("5. Show all Receptionists");
            System.out.println("6. Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    createReceptionist();
                    break;
                case "2":
                    readReceptionist();
                    break;
                case "3":
                    updateReceptionist();
                    break;
                case "4":
                    deleteReceptionist();
                    break;
                case "5":
                    showReceptionist();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("6"));
    }
}

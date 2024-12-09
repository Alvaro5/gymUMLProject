package fr.efrei.views;

import fr.efrei.domain.Receptionist;
import fr.efrei.factory.ReceptionistFactory;
import fr.efrei.repository.IReceptionistRepository;

import java.util.Arrays;
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
        String lastName, firstName, bankDetails;
        boolean onRestDay;
        double hourlyRate;
        boolean[] workingHours = new boolean[Receptionist.MAX_WORKING_HOURS];

        System.out.println("\nPlease enter the following information.");
        System.out.println("Employee ID: ");
        employeeId = sc.nextInt();
        System.out.println("Member First Name: ");
        firstName = sc.next();
        System.out.println("Member Last Name: ");
        lastName = sc.next();
        System.out.println("On rest day (true or false): ");
        onRestDay = Boolean.parseBoolean(sc.next());
        System.out.println("Bank details: ");
        bankDetails = sc.next();
        System.out.println("Hourly rate: ");
        hourlyRate = sc.nextDouble();
        System.out.println("Working hours (maximum of 8 hours per day): ");
        for (int i = 0; i < workingHours.length; i++) {
            System.out.printf("Hour %d (yes or no): ", i+1);
            String working = sc.next().toLowerCase();

            boolean valid = false;
            do {
                if (working.equals("yes")) {
                    workingHours[i] = true;
                    valid = true;
                } else if (working.equals("no")) {
                    workingHours[i] = false;
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            } while (!valid);
        }

        Receptionist receptionist = ReceptionistFactory.buildReceptionist(employeeId, lastName, firstName, onRestDay, bankDetails, hourlyRate, workingHours);

        if (receptionist != null) {
            receptionistRepository.create(receptionist);
            System.out.println("\nReceptionist created!");
            System.out.println(receptionist);
        } else {
            System.out.println("\nReceptionist not created!");

        }
    }

    private static void readReceptionist(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receptionist ID: ");
        int id = sc.nextInt();

        Receptionist readReceptionist = receptionistRepository.read(id);

        if (readReceptionist != null) {
            System.out.println("\n" + readReceptionist);
        } else {
            System.out.println("\nReceptionist not found");
        }
    }

    private static void updateReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receptionist ID to update: ");
        int id = sc.nextInt();

        // Retrieve the existing receptionist
        Receptionist existingReceptionist = receptionistRepository.read(id);

        if (existingReceptionist == null) {
            System.out.println("\nReceptionist not found!");
            return;
        }

        System.out.println("Receptionist found: ");
        System.out.println(existingReceptionist);

        // Prompt the user to update details
        System.out.println("\nEnter new details (press Enter to keep current values):");

        System.out.print("Last Name (" + existingReceptionist.getLastName() + "): ");
        String lastName = sc.nextLine();
        if (lastName.isEmpty()) lastName = existingReceptionist.getLastName();

        System.out.print("First Name (" + existingReceptionist.getFirstName() + "): ");
        String firstName = sc.nextLine();
        if (firstName.isEmpty()) firstName = existingReceptionist.getFirstName();

        System.out.print("On Rest Day (" + existingReceptionist.isOnRestDay() + "): ");
        String onRestDayInput = sc.nextLine();
        boolean onRestDay = onRestDayInput.isEmpty()
                ? existingReceptionist.isOnRestDay()
                : Boolean.parseBoolean(onRestDayInput);

        System.out.print("Bank Details (" + existingReceptionist.getBankDetails() + "): ");
        String bankDetails = sc.nextLine();
        if (bankDetails.isEmpty()) bankDetails = existingReceptionist.getBankDetails();

        System.out.print("Hourly Rate (" + existingReceptionist.getHourlyRate() + "): ");
        String hourlyRateInput = sc.nextLine();
        double hourlyRate = hourlyRateInput.isEmpty()
                ? existingReceptionist.getHourlyRate()
                : Double.parseDouble(hourlyRateInput);

        System.out.println("Working Hours (current: " + Arrays.toString(existingReceptionist.getWorkingHours()) + "): ");
        boolean[] workingHours = new boolean[Receptionist.MAX_WORKING_HOURS];
        for (int i = 0; i < workingHours.length; i++) {
            System.out.print("Hour " + (i + 1) + " (true/false, press Enter to keep current): ");
            String input = sc.nextLine();
            workingHours[i] = input.isEmpty()
                    ? existingReceptionist.getWorkingHours()[i]
                    : Boolean.parseBoolean(input);
        }

        // Create an updated receptionist object
        Receptionist updatedReceptionist = ReceptionistFactory.buildReceptionist(
                id, lastName, firstName, onRestDay, bankDetails, hourlyRate, workingHours
        );

        // Save the updated receptionist
        if (updatedReceptionist != null) {
            receptionistRepository.update(updatedReceptionist);
            System.out.println("\nReceptionist updated successfully!");
        } else {
            System.out.println("\nReceptionist update failed.");
        }
    }

    private static void deleteReceptionist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receptionist ID: ");
        int id = sc.nextInt();

        boolean deletionFlag = receptionistRepository.delete(id);

        if (deletionFlag) {
            System.out.println("\nReceptionist deleted!");
        } else {
            System.out.println("\nReceptionist not found!");
        }
    }

    public static void showReceptionists() {
        List<Receptionist> receptionistList = receptionistRepository.getAll();

        if (!receptionistList.isEmpty()) {
            System.out.println("\nList of Receptionists: ");
            for (Receptionist receptionist : receptionistList) {
                System.out.println(receptionist);
            }
        } else {
            System.out.println("\nList of Receptionists is empty!");
        }
    }

    public void receptionistMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Receptionist");
            System.out.println("2. Read Receptionist");
            System.out.println("3. Update Receptionist");
            System.out.println("4. Delete Receptionist");
            System.out.println("5. Show all Receptionists");
            System.out.println("6. Exit\n");
            choice = sc.nextLine();

            switch (choice) {
                case "1": createReceptionist(); break;
                case "2": readReceptionist(); break;
                case "3": updateReceptionist(); break;
                case "4": deleteReceptionist(); break;
                case "5": showReceptionists(); break;
                case "6": break;
                default: System.out.println("Invalid option");
            }
        } while (!choice.equals("6"));
    }
}

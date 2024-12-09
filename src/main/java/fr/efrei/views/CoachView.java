package fr.efrei.views;

import fr.efrei.domain.Coach;
import fr.efrei.factory.CoachFactory;
import fr.efrei.repository.ICoachRepository;

import java.util.Arrays;
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
        String lastName, firstName, bankDetails, sportType;
        boolean onRestDay;
        double hourlyRate;
        boolean[] availability = new boolean[10];

        System.out.println("\nPlease enter the following information.");
        System.out.println("Employee ID: ");
        employeeId = sc.nextInt();
        System.out.println("Employee Last Name: ");
        lastName = sc.next();
        System.out.println("Employee First Name: ");
        firstName = sc.next();
        System.out.println("On rest day (yes or no): ");
        onRestDay = Boolean.parseBoolean(sc.next());
        System.out.println("Bank details: ");
        bankDetails = sc.next();
        System.out.print("Sport Type (RUNNING, SPINNING, YOGA, WEIGHTLIFTING, BOXING, PERSONALIZED): ");
        sportType = sc.next();
        System.out.println("Hourly rate: ");
        hourlyRate = sc.nextDouble();
        System.out.println("Availability (10 session slots): ");
        for (int i = 0; i < availability.length; i++) {
            System.out.printf("Enter availability at hour %d (yes or no): ", i+1);
            String availabilityString = sc.next().toLowerCase();
            boolean valid = false;
            do {
                if (availabilityString.equals("yes")) {
                    availability[i] = true;
                    valid = true;
                } else if (availabilityString.equals("no")) {
                    availability[i] = false;
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            } while (!valid);
        }

        Coach coach = CoachFactory.buildCoach(employeeId, lastName, firstName, onRestDay, bankDetails, sportType, hourlyRate, availability);

        if (coach != null) {
            coachRepository.create(coach);
            System.out.println("\nCoach created!");
            System.out.println(coach);
        } else {
            System.out.println("\nCoach not created!");
        }
    }

    private static void readCoach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Coach ID: ");
        int id = sc.nextInt();

        Coach readCoach = coachRepository.read(id);

        if (readCoach != null) {
            System.out.println("\n" + readCoach);
        } else {
            System.out.println("\nCoach not found");
        }
    }

    private static void updateCoach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Coach ID to update: ");
        int id = sc.nextInt();

        Coach existingCoach = coachRepository.read(id);

        if (existingCoach == null) {
            System.out.println("\nCoach not found!");
            return;
        }

        System.out.println("\nCurrent details: ");
        System.out.println(existingCoach);

        System.out.println("\nEnter new details (press Enter to keep current values):");

        sc.nextLine(); // Clear buffer

        System.out.print("First Name (" + existingCoach.getFirstName() + "): ");
        String firstName = sc.nextLine();
        if (firstName.isEmpty()) firstName = existingCoach.getFirstName();

        System.out.print("Last Name (" + existingCoach.getLastName() + "): ");
        String lastName = sc.nextLine();
        if (lastName.isEmpty()) lastName = existingCoach.getLastName();

        System.out.print("On Rest Day (" + (existingCoach.isOnRestDay() ? "yes" : "no") + "): ");
        String onRestDayInput = sc.nextLine();
        boolean onRestDay = onRestDayInput.isEmpty() ? existingCoach.isOnRestDay() : Boolean.parseBoolean(onRestDayInput);

        System.out.print("Bank Details (" + existingCoach.getBankDetails() + "): ");
        String bankDetails = sc.nextLine();
        if (bankDetails.isEmpty()) bankDetails = existingCoach.getBankDetails();

        System.out.print("Sport Type (" + existingCoach.getSpeciality() + "): ");
        String sportTypeInput = sc.nextLine();
        Coach.SportType sportType = sportTypeInput.isEmpty()
                ? existingCoach.getSpeciality()
                : Coach.SportType.valueOf(sportTypeInput.toUpperCase());

        System.out.print("Hourly Rate (" + existingCoach.getWorkingHours() + "): ");
        String hourlyRateInput = sc.nextLine();
        double hourlyRate = hourlyRateInput.isEmpty() ? existingCoach.getWorkingHours() : Double.parseDouble(hourlyRateInput);

        System.out.println("Availability (current: " + Arrays.toString(existingCoach.getAvailability()) + "): ");
        boolean[] availability = new boolean[10];
        for (int i = 0; i < availability.length; i++) {
            System.out.printf("Enter availability at hour %d (yes or no): ", i + 1);
            String availabilityInput = sc.nextLine();
            if (availabilityInput.isEmpty()) {
                availability[i] = existingCoach.getAvailability()[i];
            } else {
                availability[i] = availabilityInput.equalsIgnoreCase("yes");
            }
        }

        Coach updatedCoach = CoachFactory.buildCoach(
                id, lastName, firstName, onRestDay, bankDetails, sportType.name(), hourlyRate, availability
        );

        if (updatedCoach != null) {
            Coach result = coachRepository.update(updatedCoach);
            if (result != null) {
                System.out.println("\nCoach updated successfully!");
                System.out.println(result);
            } else {
                System.out.println("\nFailed to update the coach.");
            }
        } else {
            System.out.println("\nInvalid input. Coach not updated.");
        }
    }

    private static void deleteCoach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Coach ID: ");
        int id = sc.nextInt();

        boolean deletionFlag = coachRepository.delete(id);

        if (deletionFlag) {
            System.out.println("\nCoach deleted!");
        } else {
            System.out.println("\nCoach not found!");
        }
    }

    public static void showCoaches() {
        List<Coach> coachList = coachRepository.getAll();

        System.out.println("\nList of Coaches: ");
        for (Coach coach : coachList) {
            System.out.println(coach);
        }
    }

    public void coachMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Coach");
            System.out.println("2. Read Coach");
            System.out.println("3. Update Coach");
            System.out.println("4. Delete Coach");
            System.out.println("5. Show all Coaches");
            System.out.println("6. Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1": createCoach(); break;
                case "2": readCoach(); break;
                case "3": updateCoach(); break;
                case "4": deleteCoach(); break;
                case "5": showCoaches(); break;
                case "6": break;
                default: System.out.println("Invalid option");
            }
        } while (!choice.equals("6"));
    }
}


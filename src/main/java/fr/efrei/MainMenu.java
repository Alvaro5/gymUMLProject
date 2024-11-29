package fr.efrei;

import fr.efrei.repository.*;
import fr.efrei.views.CoachView;
import fr.efrei.views.MemberView;
import fr.efrei.views.ReceptionistView;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        // Main menu

        // Instantiation of the repository and views classes
        IMemberRepository memberRep = MemberRepository.getRepository();
        MemberView memberView = new MemberView(memberRep);

        ICoachRepository coachRep = CoachRepository.getRepository();
        CoachView coachView = new CoachView(coachRep);

        IReceptionistRepository receptionistRep = ReceptionistRepository.getRepository();
        ReceptionistView receptionistView = new ReceptionistView(receptionistRep);

        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Member menu");
            System.out.println("2. Coach menu");
            System.out.println("3. Receptionist menu");
            System.out.println("4. Session menu");
            System.out.println("5. Exit\n");

            choice = sc.nextLine();

            switch (choice) {
                case "1": memberView.memberMenu(); break;
                case "2": coachView.coachMenu(); break;
                case "3": receptionistView.receptionistMenu(); break;
                case "4": break;
                case "5": break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("5"));
    }
}

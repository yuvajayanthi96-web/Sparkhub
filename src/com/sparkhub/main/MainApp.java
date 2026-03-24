package com.sparkhub.main;

import java.util.Scanner;
import com.sparkhub.controller.IdeaController;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IdeaController controller = new IdeaController();

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        while (true) {

            System.out.println("\n1. Add Idea");
            System.out.println("2. View Other Ideas");
            System.out.println("3. Search Idea");
            System.out.println("4. Edit My Idea");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter your idea: ");
                String idea = sc.nextLine();
                controller.createIdea(user, idea);

            } else if (choice == 2) {
                controller.showIdeas(user);

            } else if (choice == 3) {
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                controller.searchIdea(keyword);

            } else if (choice == 4) {
                System.out.print("Enter old idea: ");
                String oldIdea = sc.nextLine();

                System.out.print("Enter new idea: ");
                String newIdea = sc.nextLine();

                controller.editIdea(user, oldIdea, newIdea);

            } else if (choice == 5) {
                System.out.println("Thank You!");
                break;

            } else {
                System.out.println("Invalid choice ❌");
            }
        }

        sc.close();
    }
}

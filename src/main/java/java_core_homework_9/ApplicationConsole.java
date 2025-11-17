package java_core_homework_9;

import java_core_homework_9.controllers.FamilyController;

import java.util.List;
import java.util.Scanner;

public class ApplicationConsole {
    private static FamilyController controller = new FamilyController();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Welcome to our application!");
        System.out.println("Select desire command number");
        while (true) {
            listOfCommands();

            String commandNumber = scanner.nextLine().trim();
            if (commandNumber.equals("0") || commandNumber.equalsIgnoreCase("exit")) break;

            CommandImplementation(commandNumber);
        }
    }

    private static void listOfCommands() {
        System.out.println("1. Fill with test data");
        System.out.println("2. Display all families");
        System.out.println("3. Display families where the number of people is greater than the specified value");
        System.out.println("4. Display families where the number of people is less than the specified value");
        System.out.println("5. Count families where the number of members equals the specified value");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by index in the general list");
        System.out.println("8. Edit a family by index:");
        System.out.println("9. Delete all children older than a specified age");
        System.out.println("0. Exit");
    }

    private static void CommandImplementation(String command) {
        switch (command) {
            case "1":
                controller.addTestFamilies();
                System.out.println("Test families has been added!");
                break;
            case "2":
                if(controller.getAllFamilies().isEmpty()) {
                    System.out.println("There is no any families in DB!");
                } else {
                    System.out.println("List of families");
                    controller.displayAllFamilies();
                }
                break;
        }
    }
}

package java_core_homework_10;

import java_core_homework_10.controllers.FamilyController;
import java_core_homework_10.exceptions.FamilyOverflowException;
import java_core_homework_10.models.Family;
import java_core_homework_10.models.Human;
import java_core_homework_10.models.Woman;

import java.time.LocalDateTime;
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
            if (commandNumber.equals("0") || commandNumber.equalsIgnoreCase("exit")) {
                System.out.println("Thank you, see you later!");
                break;
            }

            try {
                CommandImplementation(commandNumber);
            } catch (FamilyOverflowException ex) {
                System.out.println("Operation failed: " + ex.getMessage());
            }
        }
    }

    private static void listOfCommands() {
        System.out.println("1. Load test data to DB");
        System.out.println("2. Display all families");
        System.out.println("3. Display families where the number of people is greater than the specified value");
        System.out.println("4. Display families where the number of people is less than the specified value");
        System.out.println("5. Count families where the number of members equals the specified value");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by index in the general list");
        System.out.println("8. Edit a family by index:");
        System.out.println("9. Delete all children older than a specified age");
        System.out.println("10. Save data to DB");
        System.out.println("0. Exit");
    }

    private static void CommandImplementation(String command) {
        switch (command) {
            case "1":
                controller.loadData(controller.addTestFamilies());
                break;
            case "2":
                if(controller.getAllFamilies().isEmpty()) {
                    System.out.println("There is no any families in DB!");
                } else {
                    System.out.println("List of families");
                    controller.displayAllFamilies();
                }
                break;
            case "3":
            case "4":
                int count = nextIntInput("Enter number:");

                List<Family> families = command.equals("3") ? controller.getFamiliesBiggerThan(count) : controller.getFamiliesLessThan(count);
                if (families.isEmpty()) {
                    System.out.println("No families found.");
                } else {
                    for (Family f : families) {
                        System.out.println((families.indexOf(f) + 1) + ". " + f.prettyFormat());
                    }
                }
                break;
            case "5":
                int exactNumberOfFamily = nextIntInput("Enter number:");

                System.out.println("Amount of families with exact number of " + exactNumberOfFamily + " = " + controller.countFamiliesWithMemberNumber(exactNumberOfFamily));
                break;
            case "6":
                System.out.println("Creating a new family. Enter mother's data:");
                String mName = nextLineInput("Mother's name:");
                String mSurname = nextLineInput("Mother's surname:");
                int mYear = nextIntInput("Mother's birth year (e.g. 1990):");
                int mMonth = nextIntInput("Mother's birth month (1-12):");
                int mDay = nextIntInput("Mother's birth day (1-31):");
                int mIq = nextIntInput("Mother's IQ (integer):");

                Human mother = new Woman();
                mother.setName(mName);
                mother.setSurname(mSurname);
                mother.setBirthDate(LocalDateTime.of(mYear, mMonth, mDay, 0, 0));
                mother.setIq(mIq);

                System.out.println("Enter father's data:");
                String fName = nextLineInput("Father's name:");
                String fSurname = nextLineInput("Father's surname:");
                int fYear = nextIntInput("Father's birth year (e.g. 1990):");
                int fMonth = nextIntInput("Father's birth month (1-12):");
                int fDay = nextIntInput("Father's birth day (1-31):");
                int fIq = nextIntInput("Father's IQ (integer):");

                Human father = new Human();
                father.setName(fName);
                father.setSurname(fSurname);
                father.setBirthDate(LocalDateTime.of(fYear, fMonth, fDay, 0, 0));
                father.setIq(fIq);

                controller.createNewFamily(mother, father);
                System.out.println("New family has been created!");
                break;
            case "7":
                while (true) {
                    int familyIndex = nextIntInput("Enter ID of family (number of family)") - 1;

                    if(!controller.deleteFamilyByIndex(familyIndex)) {
                        System.out.println("Please enter valid ID");
                    } else {
                        System.out.println("Family was deleted successfully");
                        break;
                    }
                }
            case "8":
                editFamilyMenu();
                break;
            case "9":
                int age = nextIntInput("Enter age. All children older than this age will be removed from all families:");
                controller.deleteAllChildrenOlderThan(age);
                System.out.println("Operation completed.");
                break;
            case "10":
                controller.saveFamiliesToDB();
                break;
            default:
                System.out.println("Please enter option number, that provided to you");
        }
    }

    private static void editFamilyMenu() {
        while (true) {
            System.out.println("\nEdit Family Menu:");
            System.out.println("1. Born child");
            System.out.println("2. Adopt child");
            System.out.println("3. Return to main menu");

            int choice = nextIntInput("Choose option:");
            if (choice == 3) break;

            switch (choice) {
                case 1: {
                    int familyId = nextIntInput("Enter family ID to give birth:") - 1;
                    Family family = controller.getFamilyById(familyId);
                    if (family == null) {
                        System.out.println("Invalid family ID.");
                        break;
                    }
                    String maleName = nextLineInput("Enter name to use for a boy (John for boy):");
                    String femaleName = nextLineInput("Enter name to use for a girl (Lisa for girl):");
                    try {
                        Family updated = controller.bornChild(family, maleName, femaleName);
                        System.out.println("Child born. Updated family:");
                        System.out.println(updated.prettyFormat());
                    } catch (FamilyOverflowException ex) {
                        System.out.println("Cannot add child: " + ex.getMessage());
                    }
                    break;
                }

                case 2: {
                    int familyId2 = nextIntInput("Enter family ID to adopt into:") - 1;
                    Family family2 = controller.getFamilyById(familyId2);
                    if (family2 == null) {
                        System.out.println("Invalid family ID.");
                        break;
                    }

                    System.out.println("Enter child's data for adoption:");
                    String cName = nextLineInput("Child's name:");
                    String cSurname = nextLineInput("Child's surname:");
                    int cYear = nextIntInput("Child's birth year (e.g. 2015):");
                    int cMonth = nextIntInput("Child's birth month (1-12):");
                    int cDay = nextIntInput("Child's birth day (1-31):");
                    int cIq = nextIntInput("Child's IQ (integer):");

                    Human child = new Human();
                    child.setName(cName);
                    child.setSurname(cSurname);
                    child.setBirthDate(LocalDateTime.of(cYear, cMonth, cDay, 0, 0));
                    child.setIq(cIq);

                    try {
                        Family updated = controller.adoptChild(family2, child);
                        System.out.println("Child adopted. Updated family:");
                        System.out.println(updated.prettyFormat());
                    } catch (FamilyOverflowException ex) {
                        System.out.println("Cannot adopt child: " + ex.getMessage());
                    }
                    break;
                }

                default:
                    System.out.println("Unknown option. Try again.");
            }
        }
    }

    private static int nextIntInput(String message) {
        System.out.println(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static String nextLineInput(String message) {
        String respond = "";
        while (true) {
            System.out.println(message);
            respond = scanner.nextLine().trim();
            if(respond.matches(".*\\d.*") || respond.isEmpty()) {
                System.out.println("Enter correct string! (no empty and no any numbers)");
            } else {
                break;
            }
        }
        return respond;
    }

}

package java_core_homework_2;

import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        String[][] schedule = createSchedule();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String activity;
            System.out.print("Please, input the day of the week: ");
            String dayOfTheWeek = scanner.nextLine().trim().toLowerCase();

            switch (dayOfTheWeek) {
                case "monday":
                case "tuesday":
                case "wednesday":
                case "thursday":
                case "friday":
                case "saturday":
                case "sunday":
                    activity = getActivity(dayOfTheWeek, schedule);
                    System.out.println("Your tasks for " + dayOfTheWeek + ": " + activity);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }

            if(dayOfTheWeek.equals("exit")) break;

        }

        scanner.close();
    }

    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Monday";
        schedule[0][1] = "Go to gym";

        schedule[1][0] = "Tuesday";
        schedule[1][1] = "Attend meeting";

        schedule[2][0] = "Wednesday";
        schedule[2][1] = "Work on project";

        schedule[3][0] = "Thursday";
        schedule[3][1] = "Study Java";

        schedule[4][0] = "Friday";
        schedule[4][1] = "Watch movie";

        schedule[5][0] = "Saturday";
        schedule[5][1] = "Go hiking";

        schedule[6][0] = "Sunday";
        schedule[6][1] = "Rest";

        return schedule;
    }

    public static String getActivity(String day, String[][] schedule) {
        String activity = "";
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i][0].toLowerCase().equals(day)) {
                activity = schedule[i][1];
                break;
            }
        }

        return activity;
    }
}

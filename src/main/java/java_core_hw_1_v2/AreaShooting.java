package java_core_hw_1_v2;

import java.util.Arrays;
import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {
        String[][] gameBoard = {
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-"},
        };
        int randomRow = (int) (Math.random() * 5 + 1);
        int randomColumn = (int) (Math.random() * 5 + 1);
        boolean isHit = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("All Set. Get ready to rumble!.");

        while (!isHit) {
            int rowNumber = 0, columnNumber = 0;
            boolean isWrittenRow = false;
            boolean isWrittenColumn = false;
            while (!isWrittenRow) {
                System.out.print("Enter row number: ");
                if(scanner.hasNextInt()) {
                    rowNumber = scanner.nextInt();
                    if(rowNumber < 1 || rowNumber > 5) {
                        System.out.println("Enter number in the range from 1 to 5 inclusive!");
                    } else {
                        isWrittenRow = true;
                    }
                } else {
                    System.out.println("Enter number!");
                    scanner.nextLine();
                }
            }

            scanner.nextLine();

            while (!isWrittenColumn) {
                System.out.print("Enter column number: ");
                if(scanner.hasNextInt()) {
                    columnNumber = scanner.nextInt();
                    if(columnNumber < 1 || columnNumber > 5) {
                        System.out.println("Enter number in the range from 1 to 5 inclusive!");
                    } else {
                        isWrittenColumn = true;
                    }
                } else {
                    System.out.println("Enter number!");
                    scanner.nextLine();
                }
            }

            if(rowNumber == randomRow && columnNumber == randomColumn) {
                System.out.println("You have won!");
                gameBoard[rowNumber - 1][columnNumber - 1] = "x";
                isHit = true;
            } else {
                gameBoard[rowNumber - 1][columnNumber - 1] = "*";
            }

            for (int i = 0; i < gameBoard.length; i++) {
                System.out.println(Arrays.toString(gameBoard[i]));
            }
        }

        scanner.close();
     }
}

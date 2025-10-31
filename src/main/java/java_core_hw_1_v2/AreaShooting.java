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
        int minRowNumber = 1;
        int maxRowNumber = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("All Set. Get ready to rumble!.");

        while (true) {
            int rowNumber = 0, columnNumber = 0;
            while (true) {
                System.out.print("Enter row number between 1 to 5: ");
                if(scanner.hasNextInt()) {
                    rowNumber = scanner.nextInt();
                    if(rowNumber < minRowNumber || rowNumber > maxRowNumber) {
                        System.out.println("Enter number in the range from 1 to 5 inclusive!");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Enter number (1 - 5)!");
                    scanner.nextLine();
                }
            }

            scanner.nextLine();

            while (true) {
                System.out.print("Enter column number between 1 to 5: ");
                if(scanner.hasNextInt()) {
                    columnNumber = scanner.nextInt();
                    if(columnNumber < minRowNumber || columnNumber > maxRowNumber) {
                        System.out.println("Enter number in the range from 1 to 5 inclusive!");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Enter number (1 - 5)!");
                    scanner.nextLine();
                }
            }

            if(rowNumber == randomRow && columnNumber == randomColumn) {
                System.out.println("You have won!");
                gameBoard[rowNumber - 1][columnNumber - 1] = "x";
                break;
            } else {
                gameBoard[rowNumber - 1][columnNumber - 1] = "*";
            }

            for (int i = 0; i < gameBoard.length; i++) {
                System.out.println(Arrays.toString(gameBoard[i]));
            }
        }

        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }

        scanner.close();
     }
}

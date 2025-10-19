package java_core_hw_1_v2;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 101);
        boolean isGuessed = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello to our game! what is your name? ");
        String name = scanner.nextLine();
        System.out.println("Let the game begin!");

        while (!isGuessed) {
            System.out.print("Enter your number: ");
            int guessedNumber = scanner.nextInt();
            if(guessedNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again..");
            } else if(guessedNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again..");
            } else {
                System.out.println("Congratulations, " + name + "!");
                isGuessed = true;
            }
        }
    }
}

package java_core_homework_1;

public class Calculator {
    public static void main(String[] args) {
        int firstValue = 10;
        int secondValue = 4;

        int sum = firstValue + secondValue;
        int multiply = firstValue * secondValue;
        int difference = firstValue - secondValue;
        double division = (double) firstValue / secondValue;

        System.out.println("Додавання: " + sum);
        System.out.println("Різниця: " + difference);
        System.out.println("Множення: " + multiply);
        System.out.println("Ділення: " + division);
    }
}

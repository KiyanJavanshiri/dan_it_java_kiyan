package java_core_homework_1;

public class Geometry {
    public static void main(String[] args) {
        float a = 4.5f;
        float b = 2.5f;

        System.out.println("Площа прямокутника: " + (a * b));

        byte radius = 20;
        int newRadius = radius + 10;

        double circleArea = Math.PI * Math.pow(newRadius, 2);
        System.out.println("Площа кола: " + circleArea + "cm^2");
    }
}

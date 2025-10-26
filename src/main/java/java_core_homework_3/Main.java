package java_core_homework_3;

public class Main {
    public static void main(String[] args) {
        String[][] schedule = {{"Monday", "yoga"}, {"Friday", "reading"}};
        Pet pet1 = new Pet();
        Pet pet2 = new Pet("Dog", "Jack");
        Pet pet3 = new Pet("Cat", "Gwen", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human person1 = new Human();
        Human person2 = new Human("Jack", "Hamilton", 24);
        Human person3 = new Human("Lisa", "Hamilton", 40, pet3, 90, schedule);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());

        Family family1 = new Family(person2, person3);
    }
}

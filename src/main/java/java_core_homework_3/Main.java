package java_core_homework_3;

public class Main {
    public static void main(String[] args) {
        // Example usage of methods
        String[][] schedule = {{"Monday", "yoga"}, {"Friday", "reading"}};

        Pet pet = new Pet("Cat", "Gwen", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human person1 = new Human();
        Human person2 = new Human("Jack", "Hamilton", 24);
        Human person3 = new Human("Lisa", "Hamilton", 40, pet, 90, schedule);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println("---------------------------");

        // Creating family with child
        Pet jesse = new Pet("Cat", "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, schedule);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, schedule);

        Family family = new Family(mother, father);
        family.setPet(jesse);

        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, schedule);
        family.addChild(child1);

        System.out.println(child1);

        child1.greetPet();
        child1.describePet();
        child1.feedPet();

        jesse.respond();
        jesse.foul();
        jesse.eat();

        Human child2 = new Human("Olena", "Karleone", 2004, jesse, 58, schedule);
        family.addChild(child2);

        System.out.println(family);
        System.out.println(family.countFamily());
        System.out.println(family.deleteChild(1));
        System.out.println(family);
        System.out.println(family.countFamily());
    }
}

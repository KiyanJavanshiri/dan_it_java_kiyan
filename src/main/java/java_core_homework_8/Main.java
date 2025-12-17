package java_core_homework_8;

import java_core_homework_8.controllers.FamilyController;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Example usage of methods
//        Map<String, String> schedule = createSchedule();
//        Set<String> petHabits = new HashSet<>();
//        petHabits.addAll(Arrays.asList("eat", "drink", "sleep"));
//
//        DomesticCat pet = new DomesticCat("Gwen", 2, 70, petHabits);
//
//        Human person1 = new Human();
//        Human person2 = new Man("Jack", "Hamilton");
//        Human person3 = new Woman("Lisa", "Hamilton", pet, 90, schedule);
//
//        System.out.println(person1);
//        System.out.println(person2);
//        System.out.println(person3);
//
//        System.out.println("---------------------------");
//
//        // Creating family with child
//        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);
//
//        Human mother = new Woman("Jane", "Karleone", null, 80, schedule);
//        Human father = new Man("Michael", "Jackson", null, 85, schedule);
//
//        Family family = new Family(mother, father);
//        Set<Pet> familyPets = new HashSet<>();
//        familyPets.add(jesse);
//        family.setPet(familyPets);
//
//        Human child1 = new Man("Misha", "Karleone", jesse, 68, schedule);
//        family.addChild(child1);
//
//        System.out.println(child1);
//
//        child1.greetPet();
//        child1.describePet();
//        child1.feedPet();
//
//        jesse.respond();
//        jesse.foul();
//        jesse.eat();
//
//        System.out.println(family);
//        System.out.println(family.countFamily());
//        System.out.println(family.deleteChild(1));
//        System.out.println(family);
//        System.out.println(family.countFamily());
//        System.out.println(father.describeAge());

        System.out.println("----------DAO TESTING------------");
        FamilyController controller = new FamilyController();

        System.out.println("all families");
        controller.displayAllFamilies();

        System.out.println("families bigger than 3 members");
        System.out.println(controller.getFamiliesBiggerThan(3));

        System.out.println("families less than 3 members");
        System.out.println(controller.getFamiliesLessThan(3));

        System.out.println("families with 3 members");
        System.out.println(controller.countFamiliesWithMemberNumber(3));

        System.out.println("creating new family");
        Human father = new Man("Roman", "Zhuk");
        Human mother = new Woman("Maria", "Zhuk");
        controller.createNewFamily(father, mother);
        controller.displayAllFamilies();

        System.out.println("deleting family");
        controller.deleteFamilyByIndex(0);
        controller.displayAllFamilies();

        System.out.println("born child in family");
        Family family = controller.getFamilyById(0);
        controller.bornChild(family, "John", "Oksana");
        controller.displayAllFamilies();

        System.out.println("adopting child");
        Human adopted = new Human("AdoptedKid", "Kid");
        controller.adoptChild(family, adopted);
        controller.displayAllFamilies();

        System.out.println("deleting all children older than 10 years");
        controller.deleteAllChildrenOlderThan(10);
        controller.displayAllFamilies();

        System.out.println("count of families");
        System.out.println("Count: " + controller.count());

        System.out.println("getting family by index");
        System.out.println(controller.getFamilyById(0));

        System.out.println("adding pet to family");
        controller.addPet(0, new Dog("Jason"));
        System.out.println(controller.getPets(0));
    }

    public static Map<String, String> createSchedule() {
        Map<String, String> schedule = new HashMap<>();
        String[][] DaysWithActivities = {
                {DayOfWeek.MONDAY.name(), "Go to gym"},
                {DayOfWeek.TUESDAY.name(), "Attend meeting"},
                {DayOfWeek.WEDNESDAY.name(), "Work on project"},
                {DayOfWeek.THURSDAY.name(), "Study Java"},
                {DayOfWeek.FRIDAY.name(), "Watch movie"},
                {DayOfWeek.SATURDAY.name(), "Go hiking"},
                {DayOfWeek.SUNDAY.name(), "Rest"}
        };

        for (String[] DayWithActivity : DaysWithActivities) {
            schedule.put(DayWithActivity[0], DayWithActivity[1]);
        }

        return schedule;
    }
}
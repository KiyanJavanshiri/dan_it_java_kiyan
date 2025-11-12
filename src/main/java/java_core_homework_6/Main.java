package java_core_homework_6;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Example usage of methods
        Map<String, String> schedule = createSchedule();
        Set<String> petHabits = new HashSet<>();
        petHabits.addAll(Arrays.asList("eat", "drink", "sleep"));

        DomesticCat pet = new DomesticCat("Gwen", 2, 70, petHabits);

        Human person1 = new Human();
        Human person2 = new Man("Jack", "Hamilton", 24);
        Human person3 = new Woman("Lisa", "Hamilton", 40, pet, 90, schedule);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println("---------------------------");

        // Creating family with child
        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);

        Human mother = new Woman("Jane", "Karleone", 1975, null, 80, schedule);
        Human father = new Man("Michael", "Jackson", 1974, null, 85, schedule);

        Family family = new Family(mother, father);
        family.setPet(jesse);

        Human child1 = new Man("Misha", "Karleone", 2000, jesse, 68, schedule);
        family.addChild(child1);

        System.out.println(child1);

        child1.greetPet();
        child1.describePet();
        child1.feedPet();

        jesse.respond();
        jesse.foul();
        jesse.eat();

        System.out.println(family);
        System.out.println(family.countFamily());
        System.out.println(family.deleteChild(1));
        System.out.println(family);
        System.out.println(family.countFamily());
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

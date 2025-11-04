package java_core_homework_4;

public class Main {
    public static void main(String[] args) {
//        Example usage of methods
        String[][] schedule = createSchedule();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet(Species.DOG, "Jack");
        Pet pet3 = new Pet(Species.CAT, "Gwen", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human person1 = new Human();
        Human person2 = new Human("Jack", "Hamilton", 24);
        Human person3 = new Human("Lisa", "Hamilton", 40, pet3, 90, schedule);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());

        Family family1 = new Family(person2, person3);
        System.out.println("---------------------------");
//        Creating family with child

        Pet jesse = new Pet(Species.CAT, "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, schedule);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, schedule);

        Family family = new Family(mother, father);
        family.setPet(jesse);


        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, schedule);
        family.addChild(child1);

        System.out.println(child1.toString());

        child1.greetPet();
        child1.describePet();
        child1.feedPet();

        jesse.respond();
        jesse.foul();
        jesse.eat();

//        Human child2 = new Human("Olena", "Karleone", 2004, jesse, 58, schedule);
//        family.addChild(child2);

        System.out.println(family.toString());
        System.out.println(family.countFamily());
        System.out.println(family.deleteChild(1));
        System.out.println(family.toString());
        System.out.println(family.countFamily());
    }

    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = DayOfWeek.MONDAY.name();
        schedule[0][1] = "Go to gym";

        schedule[1][0] = DayOfWeek.TUESDAY.name();
        schedule[1][1] = "Attend meeting";

        schedule[2][0] = DayOfWeek.WEDNESDAY.name();
        schedule[2][1] = "Work on project";

        schedule[3][0] = DayOfWeek.THURSDAY.name();
        schedule[3][1] = "Study Java";

        schedule[4][0] = DayOfWeek.FRIDAY.name();
        schedule[4][1] = "Watch movie";

        schedule[5][0] = DayOfWeek.SATURDAY.name();
        schedule[5][1] = "Go hiking";

        schedule[6][0] = DayOfWeek.SUNDAY.name();
        schedule[6][1] = "Rest";

        return schedule;
    }
}
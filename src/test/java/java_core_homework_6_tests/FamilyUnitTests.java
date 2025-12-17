package java_core_homework_6_tests;

import java_core_homework_6.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FamilyUnitTests {
    private Set<String> petHabits = new LinkedHashSet<>(Arrays.asList("eat", "drink", "sleep"));

    @Test
    public void PetToString() {
        Dog somePet = new Dog("Nick", 10, 80, petHabits);

        String actualToString = somePet.toString();
        String exceptedToString = "Dog{, nickname='Nick', age=10, trickLevel=80, habits=[eat, drink, sleep]}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void HumanToString() {
        Map<String, String> scheduleExample = new HashMap<>();
        scheduleExample.put(DayOfWeek.MONDAY.name(), "Go to gym");
        scheduleExample.put(DayOfWeek.TUESDAY.name(), "Attend meeting");

        Human SomeHuman = new Woman("Jane", "Karleone", 1975, null, 80, scheduleExample);

        String actualToString = SomeHuman.toString();
        String exceptedToString = "Human{name='Jane', surname='Karleone', year=1975, iq=80, schedule={MONDAY=Go to gym, TUESDAY=Attend meeting}}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void allToStringMethodTesting() {
        Map<String, String> scheduleExample = new HashMap<>();
        scheduleExample.put(DayOfWeek.MONDAY.name(), "Go to gym");
        scheduleExample.put(DayOfWeek.TUESDAY.name(), "Attend meeting");
        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);

        Human mother = new Woman("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Man("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child = new Man("Misha", "Karleone", 2000, jesse, 68, scheduleExample);

        Family family = new Family(mother, father);
        family.addChild(child);
        Set<Pet> familyPets = new HashSet<>();
        familyPets.add(jesse);
        family.setPet(familyPets);

        String actualToString = family.toString();
        String exceptedToString = "Family{mother=Human{name='Jane', surname='Karleone', year=1975, iq=80, schedule={MONDAY=Go to gym, TUESDAY=Attend meeting}}, father=Human{name='Michael', surname='Jackson', year=1974, iq=85, schedule={MONDAY=Go to gym, TUESDAY=Attend meeting}}, children=[Human{name='Misha', surname='Karleone', year=2000, iq=68, schedule={MONDAY=Go to gym, TUESDAY=Attend meeting}}], pet=[Cat{, nickname='Jesse', age=2, trickLevel=70, habits=[eat, drink, sleep]}]}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void deleteChildMethodTesting() {
        Map<String, String> scheduleExample = new HashMap<>();
        scheduleExample.put(DayOfWeek.MONDAY.name(), "Go to gym");
        scheduleExample.put(DayOfWeek.TUESDAY.name(), "Attend meeting");
        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);

        Human mother = new Woman("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Man("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Man("Misha", "Karleone", 2000, jesse, 68, scheduleExample);
        Human child2 = new Man("Sasha", "Karleone", 2010, jesse, 54, scheduleExample);
        Human child3 = new Woman("Lisa", "Karleone", 1991, jesse, 79, scheduleExample);

        Family family = new Family(mother, father);
        Set<Pet> familyPets = new HashSet<>();
        familyPets.add(jesse);
        family.setPet(familyPets);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);

        boolean expectedSuccessDeleteResult = true;
        boolean expectedFailDeleteResult = false;
        boolean actualSuccessDeleteResult = family.deleteChild(2);
        boolean actualFailDeleteResult = family.deleteChild(100);

        Assert.assertEquals(actualSuccessDeleteResult, expectedSuccessDeleteResult);
        Assert.assertEquals(actualFailDeleteResult, expectedFailDeleteResult);
    }

    @Test
    public void addChildMethodTesting() {
        Map<String, String> scheduleExample = new HashMap<>();
        scheduleExample.put(DayOfWeek.MONDAY.name(), "Go to gym");
        scheduleExample.put(DayOfWeek.TUESDAY.name(), "Attend meeting");
        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, scheduleExample);

        Family family = new Family(mother, father);
        Set<Pet> familyPets = new HashSet<>();
        familyPets.add(jesse);
        family.setPet(familyPets);
        int childrenCountBeforeAdding = family.getChildren().size();
        family.addChild(child1);
        int childrenCountAfterAdding = family.getChildren().size();

        Assert.assertTrue(childrenCountBeforeAdding < childrenCountAfterAdding);
        Assert.assertEquals(family.getChildren().get(family.getChildren().size() - 1), child1);
    }

    @Test
    public void countFamilyMethodTesting() {
        Map<String, String> scheduleExample = new HashMap<>();
        scheduleExample.put(DayOfWeek.MONDAY.name(), "Go to gym");
        scheduleExample.put(DayOfWeek.TUESDAY.name(), "Attend meeting");
        DomesticCat jesse = new DomesticCat("Jesse", 2, 70, petHabits);

        Human mother = new Woman("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Man("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Man("Misha", "Karleone", 2000, jesse, 68, scheduleExample);
        Human child2 = new Man("Sasha", "Karleone", 2010, jesse, 54, scheduleExample);
        Human child3 = new Woman("Lisa", "Karleone", 1991, jesse, 79, scheduleExample);

        Family family = new Family(mother, father);
        Set<Pet> familyPets = new HashSet<>();
        familyPets.add(jesse);
        family.setPet(familyPets);
        family.addChild(child1);
        int familyCountBeforeIncreasing = family.countFamily();
        family.addChild(child2);
        family.addChild(child3);
        int familyCountAfterIncreasing = family.countFamily();

        Assert.assertTrue(familyCountBeforeIncreasing < familyCountAfterIncreasing);
    }
}

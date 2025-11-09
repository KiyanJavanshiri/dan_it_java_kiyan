package java_core_homework_4_tests;

import java_core_homework_4.*;
import org.junit.Assert;
import org.junit.Test;

public class FamilyUnitTests {
    @Test
    public void PetToString() {
        Pet somePet = new Pet(Species.DOG, "Nick", 10, 80, new String[] {"eat", "drink", "sleep"});

        String actualToString = somePet.toString();
        String exceptedToString = "Dog{, nickname='Nick', age=10, trickLevel=80, habits=[eat, drink, sleep]}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void HumanToString() {
        String[][] scheduleExample = {{DayOfWeek.MONDAY.name(), "Go to gym"}, {DayOfWeek.TUESDAY.name(), "Attend meeting"}};

        Human SomeHuman = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);

        String actualToString = SomeHuman.toString();
        String exceptedToString = "Human{name='Jane', surname='Karleone', year=1975, iq=80, schedule=[[MONDAY, Go to gym], [TUESDAY, Attend meeting]]}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void allToStringMethodTesting() {
        String[][] scheduleExample = {{DayOfWeek.MONDAY.name(), "Go to gym"}, {DayOfWeek.TUESDAY.name(), "Attend meeting"}};
        Pet jesse = new Pet(Species.CAT, "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child = new Human("Misha", "Karleone", 2000, jesse, 68, scheduleExample);

        Family family = new Family(mother, father);
        family.setPet(jesse);
        family.addChild(child);

        String actualToString = family.toString();
        String exceptedToString = "Family{mother=Human{name='Jane', surname='Karleone', year=1975, iq=80, schedule=[[MONDAY, Go to gym], [TUESDAY, Attend meeting]]}, father=Human{name='Michael', surname='Jackson', year=1974, iq=85, schedule=[[MONDAY, Go to gym], [TUESDAY, Attend meeting]]}, children=[Human{name='Misha', surname='Karleone', year=2000, iq=68, schedule=[[MONDAY, Go to gym], [TUESDAY, Attend meeting]]}], pet=Cat{, nickname='Jesse', age=2, trickLevel=70, habits=[eat, drink, sleep]}}";

        Assert.assertEquals(actualToString, exceptedToString);
    }

    @Test
    public void deleteChildMethodTesting() {
        String[][] scheduleExample = {{DayOfWeek.MONDAY.name(), "Go to gym"}, {DayOfWeek.TUESDAY.name(), "Attend meeting"}};
        Pet jesse = new Pet(Species.CAT, "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, scheduleExample);
        Human child2 = new Human("Sasha", "Karleone", 2010, jesse, 54, scheduleExample);
        Human child3 = new Human("Lisa", "Karleone", 1991, jesse, 79, scheduleExample);

        Family family = new Family(mother, father);
        family.setPet(jesse);
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
        String[][] scheduleExample = {{DayOfWeek.MONDAY.name(), "Go to gym"}, {DayOfWeek.TUESDAY.name(), "Attend meeting"}};
        Pet jesse = new Pet(Species.CAT, "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, scheduleExample);

        Family family = new Family(mother, father);
        family.setPet(jesse);
        int childrenCountBeforeAdding = family.getChildren().length;
        family.addChild(child1);
        int childrenCountAfterAdding = family.getChildren().length;

        Assert.assertTrue(childrenCountBeforeAdding < childrenCountAfterAdding);
        Assert.assertEquals(family.getChildren()[family.getChildren().length - 1], child1);
    }

    @Test
    public void countFamilyMethodTesting() {
        String[][] scheduleExample = {{DayOfWeek.MONDAY.name(), "Go to gym"}, {DayOfWeek.TUESDAY.name(), "Attend meeting"}};
        Pet jesse = new Pet(Species.CAT, "Jesse", 2, 70, new String[] {"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1975, null, 80, scheduleExample);
        Human father = new Human("Michael", "Jackson", 1974, null, 85, scheduleExample);
        Human child1 = new Human("Misha", "Karleone", 2000, jesse, 68, scheduleExample);
        Human child2 = new Human("Sasha", "Karleone", 2010, jesse, 54, scheduleExample);
        Human child3 = new Human("Lisa", "Karleone", 1991, jesse, 79, scheduleExample);

        Family family = new Family(mother, father);
        family.setPet(jesse);
        family.addChild(child1);
        int familyCountBeforeIncreasing = family.countFamily();
        family.addChild(child2);
        family.addChild(child3);
        int familyCountAfterIncreasing = family.countFamily();

        Assert.assertTrue(familyCountBeforeIncreasing < familyCountAfterIncreasing);
    }
}

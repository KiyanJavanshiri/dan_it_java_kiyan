package java_core_homework_4_tests;

import java_core_homework_4.*;
import org.junit.Assert;
import org.junit.Test;

public class UnitTests {
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

}

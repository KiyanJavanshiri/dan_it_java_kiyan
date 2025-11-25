package java_core_homework_10.models;

import java_core_homework_10.interfaces.Foulable;
import java_core_homework_10.enums.Species;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.CAT);
    }

    public DomesticCat() {
        super();
    };

    @Override
    public void respond() {
        System.out.println("Meow Meow Meow");
    }

    @Override
    public void foul() {
        System.out.println("Oops, i did something owner meow...");
    }
}

package java_core_homework_10.models;

import java_core_homework_10.interfaces.Foulable;
import java_core_homework_10.enums.Species;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    public Dog(String nickname) {
        super(nickname);
        this.setSpecies(Species.DOG);
    }

    public Dog() {
        super();
    };

    @Override
    public void respond() {
        System.out.println("Bark Bark Bark");
    }

    @Override
    public void foul() {
        System.out.println("Oops, i did something...");
    }
}
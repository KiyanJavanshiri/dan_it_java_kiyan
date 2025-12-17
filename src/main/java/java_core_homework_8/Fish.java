package java_core_homework_8;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    public Fish(String nickname) {
        super(nickname);
        this.setSpecies(Species.FISH);
    }

    public Fish() {
        super();
    };

    @Override
    public void respond() {
        System.out.println("*bubble bubble bubble*");
    }
}
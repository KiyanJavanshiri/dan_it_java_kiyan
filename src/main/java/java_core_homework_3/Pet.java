package java_core_homework_3;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet() {}

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSpecies() {
        return species;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setTrickLevel(int trickLevel) {
        if(trickLevel >= 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            System.out.println("Enter a number between 0 - 100");
        }
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public void respond() {
        System.out.println("Hello, owner. I am - " + this.nickname + "." + " I miss you!");
    }

    public void foul() {
        System.out.println("You need to cover your tracks well...");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    @Override
    public String toString() {
        return species + "{" +
                ", nickname='" + nickname + '\'' +
                ", age=" + (age != 0 ? age : "null") +
                ", trickLevel=" + (trickLevel != 0 ? trickLevel : "null") +
                ", habits=" + (habits != null ? Arrays.toString(habits) : null) +
                '}';
    }
}

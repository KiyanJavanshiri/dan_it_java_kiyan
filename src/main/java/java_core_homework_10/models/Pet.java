package java_core_homework_10.models;

import java_core_homework_10.enums.Species;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public abstract class Pet implements Serializable {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String nickname) {
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
        return species.getPetSpecies();
    }

    public String prettyFormat() {
        return  "{" +
                "species='" + species.getPetSpecies() + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + (age != 0 ? age : "null") +
                ", trickLevel=" + (trickLevel != 0 ? trickLevel : "null") +
                ", habits=" + (habits != null ? habits.toString() : null) +
                '}';
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSpecies(Species species) {
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

    public abstract void respond();

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
        return species.getPetSpecies() + "{" +
                ", nickname='" + nickname + '\'' +
                ", age=" + (age != 0 ? age : "null") +
                ", trickLevel=" + (trickLevel != 0 ? trickLevel : "null") +
                ", habits=" + (habits != null ? habits.toString() : null) +
                '}';
    }
}
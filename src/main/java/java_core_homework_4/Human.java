package java_core_homework_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private Family family;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private String[][] schedule;

    public Human() {

    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Pet pet, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    public void greetPet() {
        if(!(pet == null)) {
            System.out.println("Hello, " + pet.getNickname());
        }
    }

    public void describePet() {
        if(!(pet == null)) {
            String tricky = pet.getTrickLevel() <= 50 ? "almost not tricky" : "very tricky";
            System.out.println("I have a/an " + pet.getSpecies() + ", his/her " + pet.getAge() + " years old, he/she is " + tricky);
        }
    }

    public void feedPet() {
        if(!(pet == null)) {
            System.out.println("I'm feeding my pet " + pet.getNickname());
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getIq() {
        return iq;
    }

    public int getYear() {
        return year;
    }

    public Pet getPet() {
        return pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(pet, human.pet) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, pet, Arrays.deepHashCode(schedule));
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + (name != null ? name : "null") + '\'' +
                ", surname='" + (surname != null ? surname : "null") + '\'' +
                ", year=" + (year != 0 ? year : "null") +
                ", iq=" + (iq != 0 ? iq : "null") +
                ", schedule=" + (schedule != null ? Arrays.deepToString(schedule) : "null") +
                '}';
    }
}
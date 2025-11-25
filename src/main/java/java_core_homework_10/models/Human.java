package java_core_homework_10.models;

import java.io.Serializable;
import java.time.Period;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    private String name;
    private Family family;
    private String surname;
    private LocalDateTime birthDate;
    private int iq;
    private Pet pet;
    private Map<String, String> schedule;

    public Human() {

    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDateTime.now();
    }

    public Human(String name, String surname, Pet pet, int iq, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDateTime.now();
//        TODO: for describeAge method usage
//        this.birthDate = LocalDateTime.of(2024, 10, 2, 14, 50);
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

    public String describeAge() {
        Period periodOfLiving = Period.between(this.birthDate.toLocalDate(), LocalDateTime.now().toLocalDate());
        return "Period of living:\nYears: " + periodOfLiving.getYears() + "\n" + "Months: " + periodOfLiving.getMonths() + "\n" + "Days: " + periodOfLiving.getDays();
    }

    public String prettyFormat() {
        return "{" +
                "name='" + (name != null ? name : "null") + '\'' +
                ", surname='" + (surname != null ? surname : "null") + '\'' +
                ", birthDate=" + (birthDate != null ? birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "null") +
                ", iq=" + (iq != 0 ? iq : "null") +
                ", schedule=" + (schedule != null ? schedule.toString() : "null") +
                '}';
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Pet getPet() {
        return pet;
    }

    public Map<String, String> getSchedule() {
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

    public void setBirthDate(LocalDateTime date) {
        this.birthDate = date;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(pet, human.pet) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, pet, schedule);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + (name != null ? name : "null") + '\'' +
                ", surname='" + (surname != null ? surname : "null") + '\'' +
                ", birthDate=" + (birthDate != null ? birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "null") +
                ", iq=" + (iq != 0 ? iq : "null") +
                ", schedule=" + (schedule != null ? schedule.toString() : "null") +
                '}';
    }
}
package java_core_homework_5;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("*bubble bubble bubble*");
    }
}

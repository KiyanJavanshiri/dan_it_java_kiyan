package java_core_homework_5;

public class Dog extends Pet implements Foulable {
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Bark Bark Bark");
    }

    @Override
    public void foul() {
        System.out.println("Oops, i did something...");
    }
}

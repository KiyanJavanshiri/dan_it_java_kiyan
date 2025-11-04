package java_core_homework_5;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.CAT);
    }

    public DomesticCat() {};

    @Override
    public void respond() {
        System.out.println("Meow Meow Meow");
    }

    @Override
    public void foul() {
        System.out.println("Oops, i did something owner meow...");
    }
}

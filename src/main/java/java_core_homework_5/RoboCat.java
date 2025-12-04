package java_core_homework_5;

public class RoboCat extends Pet {
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat() {
        super();
    };

    @Override
    public void respond() {
        System.out.println("whrrr–meowww–tchk!");
    }
}

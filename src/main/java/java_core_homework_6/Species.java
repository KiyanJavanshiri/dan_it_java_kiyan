package java_core_homework_6;

public enum Species {
    CAT("Cat"),
    DOG("Dog"),
    ROBOCAT("RoboCat"),
    FISH("Fish"),
    OWL("Owl");

    private final String petSpecies;

    Species(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public String getPetSpecies() {
        return petSpecies;
    }
}

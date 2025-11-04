package java_core_homework_5;

public enum Species {
    CAT("Cat"),
    DOG("Dog"),
    OWL("Owl");

    private final String petSpecies;

    Species(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public String getPetSpecies() {
        return petSpecies;
    }
}
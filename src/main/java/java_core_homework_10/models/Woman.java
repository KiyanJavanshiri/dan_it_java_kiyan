package java_core_homework_10.models;

import java.util.Map;

public final class Woman extends Human {
    public Woman() {
        super();
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman(String name, String surname, Pet pet, int iq, Map<String, String> schedule) {
        super(name, surname, pet, iq, schedule);
    }

    @Override
    public void greetPet() {
        if(!(getPet() == null)) {
            System.out.println("Hello my darling cutie " + getPet().getNickname() + "from a woman " + getName());
        }
    }

    public void makeUp() {
        System.out.println("I need to powder my face and dye my eyelashes");
    }
}

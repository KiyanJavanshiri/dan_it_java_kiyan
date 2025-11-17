package java_core_homework_8;

import java.util.Map;

public final class Man extends Human {
    public Man() {
        super();
    }

    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, Pet pet, int iq, Map<String, String> schedule) {
        super(name, surname, pet, iq, schedule);
    }

    @Override
    public void greetPet() {
        if(!(getPet() == null)) {
            System.out.println("Hello, " + getPet().getNickname() + "from a man " + getName());
        }
    }

    public void repairCar() {
        System.out.println("I need to check oil in engine and replace tires");
    }
}
package java_core_homework_5;

public final class Woman extends Human {
    public Woman() {
        super();
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, Pet pet, int iq, String[][] schedule) {
        super(name, surname, year, pet, iq, schedule);
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


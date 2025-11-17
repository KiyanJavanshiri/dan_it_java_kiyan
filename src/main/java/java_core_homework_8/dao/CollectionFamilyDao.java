package java_core_homework_8.dao;

import java_core_homework_8.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families = addFamilies();

    private List<Family> addFamilies() {
        List<Family> familyList = new ArrayList<>();
        Human mother1 = new Woman("Anna", "Koval");
        Human father1 = new Man("Oleh", "Koval");
        Family f1 = new Family(mother1, father1);
        f1.addChild(new Human("Maksym", "Koval"));

        Human mother2 = new Woman("Olena", "Shevchenko");
        Human father2 = new Man("Ivan", "Shevchenko");
        Family f2 = new Family(mother2, father2);

        Human mother3 = new Woman("Iryna", "Bondar");
        Human father3 = new Man("Taras", "Bondar");
        Family f3 = new Family(mother3, father3);
        f3.addChild(new Human("Sofia", "Bondar"));
        f3.addChild(new Human("Danylo", "Bondar"));

        Human mother4 = new Woman("Kateryna", "Melnyk");
        Human father4 = new Man("Andriy", "Melnyk");
        Family f4 = new Family(mother4, father4);

        Human mother5 = new Woman("Svitlana", "Hrytsenko");
        Human father5 = new Man("Petro", "Hrytsenko");
        Family f5 = new Family(mother5, father5);
        f5.addChild(new Human("Yulia", "Hrytsenko"));

        familyList.add(f1);
        familyList.add(f2);
        familyList.add(f3);
        familyList.add(f4);
        familyList.add(f5);
        return familyList;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return index < 0 || index >= families.size() ? null : families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if (index >= 0) {
            families.set(index, family);
        } else {
            families.add(family);
        }
    }
}

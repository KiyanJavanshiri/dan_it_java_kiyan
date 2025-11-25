package java_core_homework_10.dao;

import java_core_homework_10.interfaces.FamilyDao;
import java_core_homework_10.models.Family;
import java_core_homework_10.models.Human;
import java_core_homework_10.models.Man;
import java_core_homework_10.models.Woman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;

    public CollectionFamilyDao() {
        init();
    }

    public void init() {
        String rootPath = "src/main/java/java_core_homework_10/db/";
        String filePath = "families.dat";
        File databaseFile = new File(rootPath + filePath);

        if(!databaseFile.exists()) {
            this.families = new ArrayList<>();
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(rootPath + filePath))) {
            this.families = (List<Family>) inputStream.readObject();
        } catch (EOFException ex) {
            this.families = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData(List<Family> families) {
        String rootPath = "src/main/java/java_core_homework_10/db/";
        String filePath = "families.dat";

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(rootPath + filePath))) {
            outputStream.writeObject(families);
            this.families = families;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveFamiliesToDB() {
        String rootPath = "src/main/java/java_core_homework_10/db/";
        String filePath = "families.dat";

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(rootPath + filePath))) {
            outputStream.writeObject(families);
            System.out.println("Families saved to DB successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Family> addTestFamilies() {
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

package java_core_homework_8.services;

import java_core_homework_8.Family;
import java_core_homework_8.Human;
import java_core_homework_8.dao.CollectionFamilyDao;

import java.util.List;

public class FamilyService {
    private CollectionFamilyDao familyDao = new CollectionFamilyDao();

    List<Family> getAllFamilies() {
        return this.familyDao.getAllFamilies();
    }

    void displayAllFamilies() {
        System.out.println(this.familyDao.getAllFamilies());
    }

    List<Family> getFamiliesBiggerThan(int count) {
        return this.familyDao.getFamiliesBiggerThan(count);
    }

    List<Family> getFamiliesLessThan(int count) {
        return this.familyDao.getFamiliesLessThan(count);
    }

    List<Family> countFamiliesWithMemberNumber(int count) {
        return this.familyDao.countFamiliesWithMemberNumber(count);
    }

    void createNewFamily(Human father, Human mother) {
        Family newFamily = new Family(father, mother);
        this.familyDao.saveFamily(newFamily);
    }

    boolean deleteFamilyByIndex(int index) {
        return this.familyDao.deleteFamily(index);
    }

    Family bornChild(Family family, String fatherName, String motherName) {
        Human newBornChild = new Human("Jason", "Momoa");
        return this.familyDao.addChildToFamily(newBornChild, fatherName, motherName);
    }

    Family adoptChild(Family family, Human child) {
        return this.familyDao.addChildToFamily(child, family.getFather().getName(), family.getMother().getName());
    }

//    void deleteAllChildrenOlderThen(int old) {
//        this.familyDao.deleteAllChildrenOlderThen(old);
//    }
}

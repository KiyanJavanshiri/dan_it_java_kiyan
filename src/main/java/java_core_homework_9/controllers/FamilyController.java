package java_core_homework_9.controllers;

import java_core_homework_9.Family;
import java_core_homework_9.Human;
import java_core_homework_9.Pet;
import java_core_homework_9.services.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public int countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        return familyService.bornChild(family, maleName, femaleName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}

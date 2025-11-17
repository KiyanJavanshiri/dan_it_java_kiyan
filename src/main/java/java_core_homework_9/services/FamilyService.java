package java_core_homework_9.services;

import java_core_homework_9.Family;
import java_core_homework_9.Human;
import java_core_homework_9.Pet;
import java_core_homework_9.dao.CollectionFamilyDao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.getAllFamilies().forEach((el -> System.out.println(el)));
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < count)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == count)
                .collect(Collectors.toList()).toArray().length;
    }

    public void createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return this.familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        Human child;

        if (maleName.equals("John"))
            child = new Human(maleName, family.getFather().getSurname());
        else
            child = new Human(femaleName, family.getFather().getSurname());

        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : familyDao.getAllFamilies()) {
            List<Human> filteredChildren = family.getChildren().stream().filter((child) -> (LocalDateTime.now().getYear() - child.getBirthDate().getYear()) <= age).collect(Collectors.toList());
            family.setChildren(filteredChildren);
            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        Family family = familyDao.getFamilyByIndex(index);
        return family != null ? family.getPet() : null;
    }

    public void addPet(int index, Pet pet) {
        Family family = familyDao.getFamilyByIndex(index);
        if (family != null) {
            if(family.getPet() != null) {
                family.getPet().add(pet);
            } else {
                family.setPet(new HashSet<>(Arrays.asList(pet)));
            }
            familyDao.saveFamily(family);
        }
    }
}
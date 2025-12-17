package java_core_homework_10.services;

import java_core_homework_10.models.Family;
import java_core_homework_10.exceptions.FamilyOverflowException;
import java_core_homework_10.models.Human;
import java_core_homework_10.models.Pet;
import java_core_homework_10.dao.CollectionFamilyDao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDao familyDao = new CollectionFamilyDao();
    private final int MAX_FAMILY_SIZE = 3;

    public List<Family> addTestFamilies() {
        return this.familyDao.addTestFamilies();
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.getAllFamilies().forEach((el) -> System.out.println("Family №" + (this.getAllFamilies().indexOf(el) + 1) + "\n" + el.prettyFormat()));
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
        if (family.countFamily() > MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException("Family size limit exceeded. Cannot have more children. Current size: " + family.countFamily());
        }

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
        if (family.countFamily() > MAX_FAMILY_SIZE) {
            throw new FamilyOverflowException("Family size limit exceeded. Cannot adopt a child. Current size: " + family.countFamily());
        }

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

    public void loadData(List<Family> families) {
        this.familyDao.loadData(families);
    }

    public void saveFamiliesToDB() {
        this.familyDao.saveFamiliesToDB();
    }
}
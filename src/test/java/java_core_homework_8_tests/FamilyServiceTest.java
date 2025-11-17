package java_core_homework_8_tests;

import java_core_homework_8.*;
import java_core_homework_8.services.FamilyService;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FamilyServiceTest {
    private FamilyService familyService = new FamilyService();

    @Test
    public void testGetAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        assertEquals(5, families.size());
    }

    @Test
    public void testCreateNewFamily() {
        Human father = new Man("Roman", "Test");
        Human mother = new Woman("Olga", "Test");

        familyService.createNewFamily(father, mother);

        assertEquals(6, familyService.count());
    }

    @Test
    public void testDeleteFamilyByIndex() {
        boolean isDeleted = familyService.deleteFamilyByIndex(0);
        assertTrue(isDeleted);
        assertEquals(4, familyService.count());
    }

    @Test
    public void testGetFamilyById() {
        Family fam = familyService.getFamilyById(0);
        assertEquals("Anna", fam.getMother().getName());
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        List<Family> result = familyService.getFamiliesBiggerThan(2);
        assertEquals(3, result.size());
    }

    @Test
    public void testGetFamiliesLessThan() {
        List<Family> result = familyService.getFamiliesLessThan(3);
        assertEquals(2, result.size());
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        int result = familyService.countFamiliesWithMemberNumber(3);
        assertEquals(2, result);
    }

    @Test
    public void testBornChild() {
        Family fam = familyService.getFamilyById(0);

        Family updated = familyService.bornChild(fam, "Oleh", "Anna");

        assertEquals(4, updated.countFamily());
    }

    @Test
    public void testAdoptChild() {
        Family fam = familyService.getFamilyById(1);

        Human adopted = new Human("Test", "Kid");
        Family updated = familyService.adoptChild(fam, adopted);

        assertEquals(3, updated.countFamily());
    }

    @Test
    public void testDeleteAllChildrenOlderThen() {
        Family fam = familyService.getFamilyById(0);
        fam.addChild(new Human("Old", "Child"));

        familyService.deleteAllChildrenOlderThan(1);

        assertTrue(fam.getChildren().size() <= 2);
    }

    @Test
    public void testAddPet() {
        Pet dog = new Dog("Rex");
        familyService.addPet(0, dog);

        Set<Pet> pets = familyService.getPets(0);
        assertTrue(pets.contains(dog));
    }

    @Test
    public void testCount() {
        assertEquals(5, familyService.count());
    }
}

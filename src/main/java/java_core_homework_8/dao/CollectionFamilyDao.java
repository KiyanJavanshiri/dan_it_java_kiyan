package java_core_homework_8.dao;

import java_core_homework_8.Family;
import java_core_homework_8.FamilyDao;
import java_core_homework_8.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;


    public List<Family> getFamiliesBiggerThan(int count) {
        return families.stream().filter((el) -> el.countFamily() > count).collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return families.stream().filter((el) -> el.countFamily() < count).collect(Collectors.toList());
    }

    public List<Family> countFamiliesWithMemberNumber (int count) {
        return families.stream().filter((el) -> el.countFamily() == count).collect(Collectors.toList());
    }

    public Family addChildToFamily(Human child, String fatherName, String motherName) {
        Family particularFamily = families.stream().filter((el) -> el.getFather().getName().equalsIgnoreCase(fatherName) && el.getMother().getName().equalsIgnoreCase(motherName)).findFirst().get();
        int familiesIndex = families.indexOf(particularFamily);
        particularFamily.addChild(child);
        families.set(familiesIndex, particularFamily);
        return particularFamily;
    }

//    public void deleteAllChildrenOlderThen(int old) {
//        families = families.stream().map((el) -> {
//            List<Human> children = el.getChildren();
//            List <Human> filteredChildren = children.stream().filter((el) -> el.getAge() <= old).collect(Collectors.toList());
//            el.setChildren(filteredChildren);
//            return el;
//        }).collect(Collectors.toList());
//    }

    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return index < 0 || index >= families.size() ? null : families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) {
            return false;
        }
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
        if (index != -1) {
            families.set(index, family);
        } else {
            families.add(family);
        }
    }
}

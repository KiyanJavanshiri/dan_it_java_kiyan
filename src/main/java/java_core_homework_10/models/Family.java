package java_core_homework_10.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family implements Serializable {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        this.mother.setFamily(this);
    }

    public void setFather(Human father) {
        this.father = father;
        this.father.setFamily(this);
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        boolean isDeleted = false;
        if(index >= 0 && index <= this.children.size() - 1) {
            this.children.remove(index);
            isDeleted = true;
        }
        return isDeleted;
    }

    public int countFamily() {
        return 2 + this.children.size();
    }

    public String prettyFormat() {
        String childrenPrettyFormatted = "";
        String petsPrettyFormatted = "";

        if(children != null) {
            for (Human child : children) {
                childrenPrettyFormatted += "      " + child.prettyFormat() + (!(children.indexOf(child) == children.size() - 1) ? "\n" : "");
            }
        }
        if(pet != null) {
            for (Pet eachPet : pet) {
                petsPrettyFormatted += eachPet.prettyFormat() + (pet.size() > 1 ? ", " : "");
            }
        }

        return "family: \n" +
                "   mother: " + mother.prettyFormat() + ",\n" +
                "   father: " + father.prettyFormat() + ",\n" +
                "   children: \n" + childrenPrettyFormatted + "\n" +
                "   pets: " + "[" + petsPrettyFormatted + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pet);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children.toString() +
                ", pet=" + pet +
                '}';
    }
}
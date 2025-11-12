package java_core_homework_6;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];

        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Pet getPet() {
        return pet;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
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

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public void addChild(Human child) {
        Human[] newChildrenArr = Arrays.copyOf(this.children, this.children.length + 1);
        child.setFamily(this);
        newChildrenArr[newChildrenArr.length - 1] = child;
        this.children = newChildrenArr;
    }

    public boolean deleteChild(int index) {
        boolean isDeleted = false;
        if(index >= 0 && index <= this.children.length - 1) {
            Human[] newChildrenArr = Arrays.copyOf(this.children, this.children.length - 1);
            for(int i = 0; i < this.children.length; i++) {
                if(i != index) {
                    newChildrenArr[i] = this.children[i];
                }
            }
            this.children = newChildrenArr;
            isDeleted = true;
        }
        return isDeleted;
    }

    public int countFamily() {
        return 2 + this.children.length;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }
}
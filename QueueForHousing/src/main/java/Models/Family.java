package Models;

public class Family {

    private Father father;
    private Mother mother;
    private int children = 0;

    public Family(Father father, Mother mother, int children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Father getFather() {
        return father;
    }

    public Mother getMother() {
        return mother;
    }

    public int getChildren() {
        return children;
    }
}

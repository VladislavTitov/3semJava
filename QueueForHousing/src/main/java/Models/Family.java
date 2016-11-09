package Models;

import java.util.ArrayList;

public class Family {

    private final Father father;
    private final Mother mother;
    private final ArrayList<Child> children;

    public static class Builder{
        private Father father;
        private Mother mother;
        private ArrayList<Child> children;

        public Builder setFather(Father father) {
            this.father = father;
            return this;
        }

        public Builder setMother(Mother mother) {
            this.mother = mother;
            return this;
        }

        public Builder setChildren(ArrayList<Child> children) {
            this.children = children;
            return this;
        }

        public Family build(){
            return new Family(this);
        }
    }

    private Family(Builder builder) {
        this.father = builder.father;
        this.mother = builder.mother;
        this.children = builder.children;
    }

    public Father getFather() {
        return father;
    }

    public Mother getMother() {
        return mother;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }


}

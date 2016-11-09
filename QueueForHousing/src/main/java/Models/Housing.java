package Models;

public class Housing {
    private final Family family;
    private final int condition;
    private final Wishes wishes;

    public static class Builder{
        private Family family;
        private int condition;
        private Wishes wishes;

        public Builder setFamily(Family family) {
            this.family = family;
            return this;
        }

        public Builder setCondition(int condition) {
            this.condition = condition;
            return this;
        }

        public Builder setWishes(Wishes wishes) {
            this.wishes = wishes;
            return this;
        }

        public Housing build(){
            return new Housing(this);
        }
    }

    private Housing(Builder builder){
        this.family = builder.family;
        this.condition = builder.condition;
        this.wishes = builder.wishes;
    }

    public Family getFamily() {
        return family;
    }

    public int getCondition() {
        return condition;
    }

    public Wishes getWishes() {
        return wishes;
    }
}

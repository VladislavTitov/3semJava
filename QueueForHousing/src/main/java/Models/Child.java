package Models;

public class Child {
    private final String surname;
    private final String name;
    private final String patronymic;

    public static class Builder{

        private String surname;
        private String name;
        private String patronymic;

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Child build(){
            return new Child(this);
        }
    }

    private Child(Builder builder) {
        this.surname = builder.surname;
        this.name = builder.name;
        this.patronymic = builder.patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }
}

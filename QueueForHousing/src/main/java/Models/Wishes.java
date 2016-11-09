package Models;

public class Wishes {

    private final int roomsCount;
    private final boolean kindergarden;
    private final boolean school;
    private final String district;

    public static class Builder{

        private int roomsCount;
        private boolean kindergarden;
        private boolean school;
        private String district;

        public Builder setRoomsCount(int roomsCount) {
            this.roomsCount = roomsCount;
            return this;
        }

        public Builder setKindergarden(boolean kindergarden) {
            this.kindergarden = kindergarden;
            return this;
        }

        public Builder setSchool(boolean school) {
            this.school = school;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Wishes build(){
            return new Wishes(this);
        }
    }

    private Wishes(Builder builder){
        this.roomsCount = builder.roomsCount;
        this.kindergarden = builder.kindergarden;
        this.school = builder.school;
        this.district = builder.district;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public boolean isKindergarden() {
        return kindergarden;
    }

    public boolean isSchool() {
        return school;
    }

    public String getDistrict() {
        return district;
    }
}

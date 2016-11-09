package Models;

import java.time.LocalDate;

public class Queue {
    public static final int MAX_ROOMS_COUNT = 5;
    public static final int MAX_CONDITION_VALUE = 4;

    private final Housing housing;
    private final boolean promotions;
    private final boolean outOfQueue;
    private final boolean firstOfQueue;
    private final LocalDate date;

    public static class Builder{
        private Housing housing;
        private boolean promotions;
        private boolean outOfQueue;
        private boolean firstOfQueue;
        private LocalDate date;

        public Builder setHousing(Housing housing) {
            this.housing = housing;
            return this;
        }

        public Builder setPromotions(boolean promotions) {
            this.promotions = promotions;
            return this;
        }

        public Builder setOutOfQueue(boolean outOfQueue) {
            this.outOfQueue = outOfQueue;
            return this;
        }

        public Builder setFirstOfQueue(boolean firstOfQueue) {
            this.firstOfQueue = firstOfQueue;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Queue build(){
            return new Queue(this);
        }
    }

    private Queue(Builder builder){
        this.housing = builder.housing;
        this.promotions = builder.promotions;
        this.outOfQueue = builder.outOfQueue;
        this.firstOfQueue = builder.firstOfQueue;
        this.date = builder.date;
    }

    public Housing getHousing() {
        return housing;
    }

    public boolean isPromotions() {
        return promotions;
    }

    public boolean isOutOfQueue() {
        return outOfQueue;
    }

    public boolean isFirstOfQueue() {
        return firstOfQueue;
    }

    public LocalDate getDate() {
        return date;
    }
}

package adapter;

import java.time.LocalTime;

public class PackedMeal {
    private boolean haveUtensils;

    private String mainDish;
    private String side;
    private String drink;

    private LocalTime packedTime;

    public PackedMeal(boolean haveUtensils, String mainDish, String side, String drink) {
        this.haveUtensils = haveUtensils;
        this.mainDish = mainDish;
        this.side = side;
        this.drink = drink;
        this.packedTime = LocalTime.now();
    }

    public String toString() {
        return "PackedMeal[haveUtensils=" + haveUtensils +
                ", mainDish=" + mainDish +
                ", side=" + side +
                ", drink=" + drink +
                ", packedTime=" + TimeConverter.getTime(packedTime) +
                "]";
    }
}

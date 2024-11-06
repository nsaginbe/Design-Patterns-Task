package flyweight;

import facade.MealType;

import java.util.ArrayList;
import java.util.List;

public class MealFactory {
    private static List<MealType> mealTypes = new ArrayList<>();

    public static MealType getMealType(String mainDish, String side, String drink) {
        MealType mealType = new MealType(mainDish, side, drink);

        boolean isNull = true;
        int index = -1;
        for (int i = 0; i < mealTypes.size(); i++) {
            if (isEqual(mealType, mealTypes.get(i))){
                isNull = false;
                index = i;
                break;
            }
        }

        if (!isNull) {
            return mealTypes.get(index);
        }

        mealTypes.add(mealType);
        return mealTypes.getLast();
    }

    private static boolean isEqual(MealType A, MealType B) {
        return A.toString().equals(B.toString());
    }
}

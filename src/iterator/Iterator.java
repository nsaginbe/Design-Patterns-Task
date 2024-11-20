package iterator;

import builder.Meal;

public interface Iterator {
    Meal next();
    boolean hasNext();
}

package iterator;

import builder.Meal;

import java.util.List;

// Order = Meal
public class OrderIterator implements Iterator {
    private OrderList orderList;

    private int currentIndex;
    private List<? super Meal> cache;

    public OrderIterator(OrderList orderList) {
        this.orderList = orderList;
        this.currentIndex = -1;
    }

    private void lazyInit() {
        if (cache == null) {
            cache = orderList.getOrderList();
        }
    }

    @Override
    public Meal next() {
        if (hasNext()) {
            currentIndex++;
            return (Meal) cache.get(currentIndex);
        }
        else return null;
    }

    @Override
    public boolean hasNext() {
        lazyInit();
        return currentIndex + 1 < cache.size();
    }
}

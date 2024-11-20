package iterator;
import builder.Meal;

import java.util.List;

public class OrderList implements Collection {
    private List<? super Meal> orderList;

    public OrderList(List<? super Meal> orderList) {
        this.orderList = orderList;
    }

    public List<? super Meal> getOrderList() {
        return orderList;
    }

    @Override
    public Iterator createIterator() {
        return new OrderIterator(this);
    }
}

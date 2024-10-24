import composite.*;
import decorator.ExtraCheese;
import decorator.ExtraTomato;

public class TestCompositeAndDecorator {
    private static Composite order;

    public static void main(String[] args) {

        // test 1 (only main dish)
        test1();
        getResult(1, order);

        // test 2 (combo)
        test2();
        getResult(2, order);

        // test 3 (combo in combo)
        test3();
        getResult(3, order);

        // test 4 (combo in combo in combo)
        test4();
        getResult(4, order);

        // test 5 (main dish with extra)
        test5();
        getResult(5, order);

        // test 6 (side with 2 extras)
        test6();
        getResult(6, order);

        // test 7 (combining combo and decorators)
        test7();
        getResult(7, order);
    }

    private static void test7() {
        order = new Composite();

        Composite combo = new Composite();

        Component mainDish = new MainDish("besh", 34);
        mainDish = new ExtraTomato(mainDish, 4);
        Component drink = new Drink("pepsi", 12);

        combo.add(mainDish);
        combo.add(drink);

        order.add(combo);

        Component side = new Side("fries", 7);
        side = new ExtraTomato(side, 2);
        side = new ExtraCheese(side, 5);

        order.add(side);
    }

    private static void test6() {
        order = new Composite();

        Component side = new Side("buter", 14);
        side = new ExtraCheese(side, 5);
        side = new ExtraTomato(side, 2);

        order.add(side);
    }

    private static void test5() {
        order = new Composite();

        Component mainDish = new MainDish("samsa", 25);
        mainDish = new ExtraCheese(mainDish, 3);

        order.add(mainDish);
    }

    private static void test4() {
        order = new Composite();

        Composite combo1 = new Composite();

        Composite combo2 = new Composite();
        combo2.add(new MainDish("lapsha", 32));
        combo2.add(new Drink("qymyz", 100));

        combo1.add(combo2);
        combo1.add(new MainDish("rozhki", 5));
        combo1.add(new Side("mai", 41));

        order.add(combo1);
        order.add(new Drink("barjomi", 23));
    }

    private static void test3() {
        order = new Composite();

        Composite combo = new Composite();
        combo.add(new MainDish("soup", 13));
        combo.add(new Side("salad", 10));

        order.add(combo);
        order.add(new Drink("water", 1));
    }

    private static void test2() {
        order = new Composite();

        order.add(new MainDish("chicken", 20));
        order.add(new Side("fries", 15));
        order.add(new Drink("cola", 3));
    }

    private static void test1() {
        order = new Composite();

        order.add(new MainDish("besh", 50));
    }

    private static void getResult(int test, Composite order) {
        System.out.println("Test " + test + ": ");
        System.out.println(order.toString(""));
        System.out.println("Total: " + order.calculate() + "\n");
    }
}

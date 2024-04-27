package DesignPatterns.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        OrderBuilder builder = new OrderBuilder();
        OrderedItems orderedItems = builder.preparePizza();
        orderedItems.showItems();
    }
}

package book.factory.factorymethod;

public class PizzaTestDrive {
    public static void main(String[] args) {

        PizzaStore store;

        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza.getName());

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}

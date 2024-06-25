package JavaCodingProblems.Concurrency.PerThreadContextThreadLocal;

public class Order {
    private final int customerId;

    public Order(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

}

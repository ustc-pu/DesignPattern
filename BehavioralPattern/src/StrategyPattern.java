public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
        cart1.checkOut(123.45);

        ShoppingCart cart2 = new ShoppingCart(new PaypalPayment());
        cart2.checkOut(55.5);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid %f through credit card\n", amount);
    }
}

class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid %f through paypal\n", amount);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkOut(double amount) {
        paymentStrategy.pay(amount);
    }
}
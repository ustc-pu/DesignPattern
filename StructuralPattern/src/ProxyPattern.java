public class ProxyPattern {
    public static void main(String[] args) {
        ExpensiveObject expensiveObject = new ExpensiveObjectProxy();
        expensiveObject.process();
        expensiveObject.process();
    }
}

interface ExpensiveObject {
    void process();
}

class ExpensiveObjectImpl implements ExpensiveObject {
    @Override
    public void process() {
        System.out.println("This is ExpensiveObject Impl processing...");
    }

    public ExpensiveObjectImpl() {
        loadingExpensiveConfig();
    }

    private void loadingExpensiveConfig() {
        System.out.println("Loading initial configurations...");
    }
}

/**
 * It provides a surrogate or placeholder for another object to control access to it.
 * It is often used to add a level of indirection when dealing with sensitive or resource-intensive operations.
 * It controls access to the impl object.
 */
class ExpensiveObjectProxy implements ExpensiveObject {
    private ExpensiveObject expensiveObject;


    /**
     * Lazy initialization of the impl object, and it would only be created once.
     * Delegate the request to Impl class
     */
    @Override
    public void process() {
        if(expensiveObject == null) {
            expensiveObject = new ExpensiveObjectImpl();
        }
        System.out.println("This is ExpensiveObject Proxy processing...");
        expensiveObject.process();
    }
}
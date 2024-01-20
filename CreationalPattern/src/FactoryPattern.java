
interface Product {
    void display();
}

class ProductA implements Product {
    @Override
    public void display() {
        System.out.println("This is Product A");
    }
}

class ProductB implements Product {
    @Override
    public void display() {
        System.out.println("This is Product B");
    }
}

interface ProductFactory {
    Product createProduct();
}

class ProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class ProductBFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

public class FactoryPattern {

    // https://refactoring.guru/design-patterns/factory-method

    /**
     * Instead of creating object using new operator, we create product from a special class called Factory
     * Now you can override the factory method in a subclass and change the class of products being created by the method.
     * There’s a slight limitation though: subclasses may return different types of products only if these products have a common base class or interface.
     * Also, the factory method in the base class should have its return type declared as this interface.
     * @param args
     */
    public static void main(String[] args) {
        ProductFactory productAFactory = new ProductAFactory();
        Product productA = productAFactory.createProduct();
        productA.display();

        ProductFactory productBFactory = new ProductBFactory();
        Product productB = productBFactory.createProduct();
        productB.display();
    }
}

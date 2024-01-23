public class DecoratorPattern {

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.printf("$Cost %f, description: %s \n", simpleCoffee.cost(), simpleCoffee.description());

        // only add milk
        Coffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.printf("$Cost %f, description: %s \n", milkCoffee.cost(), milkCoffee.description());

        // only add sugar
        Coffee sugarCoffee = new SugarCoffee(simpleCoffee);
        System.out.printf("$Cost %f, description: %s \n", sugarCoffee.cost(), sugarCoffee.description());

        // add both
        Coffee sweetMilkCoffee = new SugarCoffee(new MilkCoffee(simpleCoffee));
        System.out.printf("$Cost %f, description: %s \n", sweetMilkCoffee.cost(), sweetMilkCoffee.description());

    }

}

interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 3.0;
    }

    @Override
    public String description() {
        return "This is a simple coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    private Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String description() {
       return decoratedCoffee.description();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

class MilkCoffee extends CoffeeDecorator {

    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
         return super.description() + " with Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 1.5;
    }
}

class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return super.description() + " with Sugar.";
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }
}

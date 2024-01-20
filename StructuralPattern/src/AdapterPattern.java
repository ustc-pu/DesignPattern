public class AdapterPattern {
    // https://refactoring.guru/design-patterns/adapter
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        TargetAdapter adapter = new TargetAdapter(adaptee);
        adapter.request();
    }
}

// Target is the interface that the client code expects.
interface Target {
    void request();
}

// This is an extisting class, not compatible to the Target interface
// can not interact with Target easily

class Adaptee {
    public void specificRequest() {
        System.out.println("This is adaptee's specific request!");
    }
}

// Adapter is the class that implements the Target interface and contains an instance of Adaptee.
// It adapts the interface of Adaptee to match the Target interface.
class TargetAdapter implements Target{
    private Adaptee adaptee;

    public TargetAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request(){
        adaptee.specificRequest();
    }
}
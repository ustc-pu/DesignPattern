public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.display();
        System.out.println(singleton1);

        Singleton singleton2 = Singleton.getInstance();
        singleton2.display();
        System.out.println(singleton2);

        // True
        System.out.println(singleton2 == singleton1);
    }
}

class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void display() {
        System.out.println("This is a singleton object.");
    }
}
import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();

        Observer observer1 = new ObserverImpl(subject);
        Observer observer2 = new ObserverImpl(subject);

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.setState("state1");
        subject.notifyObservers();

        subject.setState("state2");
        subject.removeObserver(observer1);
        subject.notifyObservers();
    }
}

interface Observer {
    void update();
}

class ObserverImpl implements Observer {
    private String observerState;
    private Subject subject;

    public ObserverImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getState();
        System.out.printf("Observer %s updated with state: %s\n", this, observerState);
    }
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setState(String state);
    String getState();
}

class SubjectImpl implements Subject {
    private List<Observer> observers;
    private String state;

    public SubjectImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }
}

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args) {
        Aggregator aggregator = new AggregatorImpl<String>();
        aggregator.add("Phoebe Buffay");
        aggregator.add("Monica Geller");
        aggregator.add("Rachel Green");
        aggregator.add("Joey Tribbiani");
        aggregator.add("Chandler Bing");
        aggregator.add("Ross Geller");

        for(Iterator iterator = aggregator.createIterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        Aggregator intAggregator = new AggregatorImpl<Integer>();
        intAggregator.add(15);
        intAggregator.add(18);
        intAggregator.add(21);

        for(Iterator iterator = intAggregator.createIterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}


interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregator<T> {
    Iterator createIterator();
    void add(T element);
}

class IteratorImpl<T> implements Iterator{
    private List<T> elements;
    private int pos = 0;

    public IteratorImpl(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return pos < elements.size();
    }

    @Override
    public Object next() {
        if(hasNext()) {
            Object element = elements.get(pos);
            pos++;
            return element;
        }
        return null;
    }
}

class AggregatorImpl<T> implements Aggregator<T>{
    private List<T> elements = new ArrayList<>();

    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public Iterator createIterator() {
        return new IteratorImpl(elements);
    }
}
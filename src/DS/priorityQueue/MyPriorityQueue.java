package DS.priorityQueue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyPriorityQueue<T> implements Iterable<T> {

    

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}

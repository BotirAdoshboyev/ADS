package DS.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class MyArrayList<T> implements Iterable<T> {

    private T[] arr;
    private int len;
    private int capacity;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity, capacity cannot be less than zero, provided " + capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return len;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(T obj, int index) {
        if (index < 0)
            throw new IllegalArgumentException("Illegal index, index cannot be less than zero, provided " + index);
        arr[index] = obj;
    }

    public void clear() {
        for (int i = 0; i < size(); i++)
            arr[i] = null;
        len = 0;
    }

    public void add(T obj) {
        resize();
        arr[len++] = obj;
    }

    public void removeAt(int at) {
        resize();
        if (at > len) throw new IllegalArgumentException("Index out of bound, " + at + " out of " + len);
        for (int i = at; i < len; i++)
            arr[i] = arr[i + 1];
        arr[len--] = null;
        System.out.println(Arrays.toString(arr));
    }

    private void resize() {
        if (len == capacity) { // double the size
            capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            if (size() >= 0) System.arraycopy(arr, 0, newArr, 0, size());
            arr = newArr;
        } else if (len * 2 == capacity && capacity > 16) { // half the size and min capacity is set 16
            System.out.println("len: " + len + " capacity: " + capacity + " half");
            capacity /= 2;
            T[] newArr = (T[]) new Object[capacity];
            if (size() >= 0) System.arraycopy(arr, 0, newArr, 0, size());
            arr = newArr;
            System.out.println("test: " + Arrays.toString(arr));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size(); i++) {
            str.append(arr[i].toString());
            if (i != size() - 1)
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}

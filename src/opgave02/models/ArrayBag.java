package opgave02.models;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /**
     * Create a bag with the given capacity.
     */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /**
     * Create a bag with capacity 10.
     */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        if (!isFull()) {
            items[size] = newEntry;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            E removedItem = items[size - 1];
            items[size] = null;
            size--;
            return removedItem;
        }
        return null;
    }

    @Override
    public boolean remove(E anEntry) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size - 1; i++) {
            if (items[i].equals(anEntry)) {
                items[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int frequency = 0;
        for (E item : items) {
            if (item != null) {
                if (item.equals(anEntry)) {
                    frequency++;
                }
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(E anEntry) {
        for (E item : items) {
            if (item == anEntry) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = items[i];
        }
        return array;
    }
}
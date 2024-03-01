package opgave03.models;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArrayListRing<E> implements Ring<E> {
    private ArrayList<E> items;
    private E currentItem;

    public ArrayListRing() {
        items = new ArrayList<>();
        currentItem = null;
    }

    @Override
    public void advance() {
        if (!isEmpty() && items.indexOf(currentItem) < size() - 1) {
            currentItem = items.get(items.indexOf(currentItem) + 1);
        } else if (!isEmpty() && items.indexOf(currentItem) == size() - 1) {
            currentItem = items.getFirst();
        }
    }

    @Override
    public E getCurrentItem() {
        if (isEmpty()) {
            throw new RuntimeException("Ring is empty.");
        }
        return currentItem;
    }


    public int getCurrentItemIndex() {
        if (isEmpty()) {
            throw new RuntimeException("Ring is empty.");
        }
        return items.indexOf(currentItem);
    }

    @Override
    public void add(E item) {
        if (isEmpty()) {
            items.add(item);
            currentItem = item;
        } else if (!isEmpty() && items.indexOf(currentItem) < size()) {
            int currentIndex = items.indexOf(currentItem);
            items.add(currentIndex + 1, item);
            currentItem = items.get(currentIndex + 1);
        }
    }

    @Override
    public boolean removeItem(E item) {
        if (items.contains(item)) {
            int indexOfRemoved = items.indexOf(item);
            if (indexOfRemoved == items.indexOf(currentItem) && indexOfRemoved < size() - 1) {
                currentItem = items.get(indexOfRemoved + 1);
            } else if (indexOfRemoved == items.indexOf(currentItem) && indexOfRemoved == size() - 1) {
                currentItem = items.getFirst();
            }
            items.remove(indexOfRemoved);
            return true;
        }
        return false;
    }

    @Override
    public E removeCurrentItem() {
        if (isEmpty()) {
            throw new RuntimeException("The ring is on fire and also empty");
        }
        int indexOfRemoved = items.indexOf(currentItem);
        if (indexOfRemoved < size() - 1) {
            currentItem = items.get(indexOfRemoved + 1);
        } else if (indexOfRemoved == size() - 1) {
            currentItem = items.getFirst();
        }

        return items.remove(indexOfRemoved);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void print() {
        System.out.println(items);
    }

     @Override
     public void map(Function<E, E> function) {
        int currentItemIndex = getCurrentItemIndex();
         for (int i = 0; i < items.size(); i++) {
             items.set(i, function.apply(items.get(i)));
         }
         currentItem = items.get(currentItemIndex);
     }

     @Override
     public ArrayListRing<E> where(Predicate<E> predicate) {
         ArrayListRing<E> ring = new ArrayListRing<E>();
         for (E item : items) {
             if (predicate.test(item)) {
                 ring.add(item);
             }
         }
         return ring;
     }
}

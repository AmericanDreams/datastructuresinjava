package mir.project.stack.impl;

import java.util.ArrayList;
import java.util.Stack;

public class StackWithArray<T extends Comparable<T>> extends Stack<T> {

    private ArrayList<T> list;

    public StackWithArray() {
        list = new ArrayList<>();
    }

    @Override
    public T push(T item) {
        list.add(item);
        return list.get(list.size() - 1);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return list.remove(list.size() - 1);
    }

    @Override
    public synchronized T peek() {
        if (isEmpty()) return null;
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

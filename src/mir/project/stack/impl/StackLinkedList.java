package mir.project.stack.impl;

import java.util.Stack;

public class StackLinkedList<T extends Comparable<T>> extends Stack<T> {

    private Node<T> root;
    private int size;

    //O(1)
    @Override
    public T push(T item) {
        if (isEmpty()) {
            root = new Node<>(item);
        } else {
           Node<T> node = new Node<>(item);
           node.next = root;
           root = node;
        }

        size++;
        return root.data;
    }

    //O(1)
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return root.data;
        }
    }

    //O(1)
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = root.data;
            root = root.next;
            size--;
            return temp;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public synchronized int size() {
        return size;
    }
}

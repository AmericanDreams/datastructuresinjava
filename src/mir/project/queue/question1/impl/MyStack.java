package mir.project.queue.question1.impl;

/**
 * Interview Question #1
 *
 * The aim is to design an algorithm that can return the maximum item of a stack in
 * O(1) running time complexity. We can use O(N) extra memory!
 *
 * Hint: we can use another stack to track the max item
 *
 * */
public class MyStack<T extends Comparable<T>> implements MaxStack<T> {

    private int size;
    private Node<T> root;
    private Node<T> maxRoot;

    @Override
    public void push(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            root = node;
            maxRoot = node;
        } else {
            node.next = root;
            root = node;
            pushToMax(data);
        }
        size++;
    }

    private void pushToMax(T data) {
        if(maxRoot.data.compareTo(data) > 0) {
            data = maxRoot.data;
        }

        Node<T> node = new Node<>(data);
        node.next = maxRoot;
        maxRoot = node;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = root.data;
            root = root.next;
            popMax();
            size--;
            return temp;
        }
    }

    private void popMax() {
        maxRoot = maxRoot.next;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return root.data;
        }
    }

    @Override
    public T peekMax() {
        if (isEmpty()) {
            return null;
        } else {
            return maxRoot.data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

package mir.project.queue.impl;

public class QueueWithLinkedList<T extends Comparable<T>> {
    private Node<T> root;
    private Node<T> tail;
    private int size;

    // enQueue() next () tail <- prev ------ next -> root deQueue() prev()
    public void enQueue(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            tail = node;
            root = node;
            size++;
        } else {
            if (size() == 1) {
                root.next = node;
                node.prev = root;
                tail = node;
                size++;
            } else{
                node.prev = tail;
                tail.next = node;
                tail = node;
                size++;
            }
        }
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        } else {
            if (size() == 1) {
                T temp = root.data;
                root = null;
                tail = null;
                size--;
                return temp;
            } else {
                T temp = root.data;
                root = root.next;
                size--;
                return temp;
            }
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return root.data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }



}

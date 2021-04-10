package mir.project.queue.impl;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
    }
}

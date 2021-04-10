package mir.project.queue.impl2;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
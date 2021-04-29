package mir.project.hashtable.implwithchaining;

public class Node<T extends Comparable> {
    public T data;
    public String key;
    public Node<T> next;

    Node(String key, T data) {
        this.key = key;
        this.data = data;
    }
}

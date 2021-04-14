package mir.project.splaytree;

public interface Tree<T extends Comparable<T>> {
    T find(T data);
    T delete(T data);
    void traverse();
    void insert(T data);
    Node<T> getRoot();
}

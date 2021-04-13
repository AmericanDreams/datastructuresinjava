package mir.project.avl.impl1;

public interface Tree<T extends Comparable<T>> {
    void insert(T data);
    void traverse();
    T delete(T data);
}

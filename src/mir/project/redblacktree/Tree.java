package mir.project.redblacktree;

public interface Tree<T extends Comparable<T>> {
    void traverse();
    void insert(T data);
}

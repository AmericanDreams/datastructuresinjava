package mir.project.bst.impl1;

public interface BST<T extends Comparable<T>> {
    public void insert(T data);
    public T delete(T data);
    public void traverse(TraverseType TYPE);
    public T search(T data);
}

enum TraverseType {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER;
}

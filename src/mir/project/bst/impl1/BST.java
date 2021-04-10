package mir.project.bst.impl1;

public interface BST<T extends Comparable<T>> {
    public void insert(T data);
    public T delete(T data);
    public void traverse(TraverseType TYPE);
    public T search(T data);
    public T getMin();
    public T getMax();
    public Node<T> getRoot();

    /**
     * <p><strong>Interview Question #1:</strong></p>
     * <p>Write an efficient algorithm thats able to compare two binary search trees. The method returns
     * <em>true </em>if the trees are identical (same topology with same values in the nodes) otherwise it
     * returns <em>false</em>.</p>
     * */
    public boolean isEqual(BST<T> tree);


    /**
     * <p><strong>Interview Question #2:</strong></p>
     * <p>Write an efficient in-place algorithm to find the k-th smallest (largest) item in a binary search tree!</p>
     * */
    public T getKthBiggestValue(int k);


    /**
     * <p><strong>Interview Question #3:</strong></p><p>Write an efficient algorithm to calculate the total
     * sum of ages in a family tree. A family tree is a binary search tree in this case where all
     * the nodes contain a Person object with [name,age] attributes. </p><p>Hint: we have to make a
     * tree traversal so the running time of the algoritm will be <strong>O(N)</strong> linear running time</p>
     * */
    public int getSum();
}

enum TraverseType {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER;
}

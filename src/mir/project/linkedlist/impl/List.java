package mir.project.linkedlist.impl;

public interface List<T extends Comparable<T>> {
    public void addToBeginning(T t);
    public void addToEnd(T t);
    public void removeFromBeginning();
    public void remove(T t);
    public boolean isEmpty();
    public int size();
    public void traverseList();


    /**
     * Interview Question #1:
     *
     * Suppose we have a standard linked list. Construct an in-place
     * (without extra memory) algorithm thats able to find the middle node !
     * */
    public T getDataOfMiddleNode();

    /**
     * Interview Question #2:
     *
     * Construct an in-place algorithm to reverse a linked list!
     * */

    public void reverse();
}

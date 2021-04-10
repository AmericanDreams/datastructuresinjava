package mir.project.linkedlist.impl;

public class SingleLinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void addToBeginning(T t) {
        if (isEmpty()) {
            root = new Node<>(t);
        } else {
            Node<T> newNode = new Node<>(t);
            newNode.setNext(root);
            root = newNode;
        }
        size++;
    }

    @Override
    public void addToEnd(T t) {
        if (isEmpty()) {
            root = new Node<>(t);
        } else {
            Node item = root;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(new Node(t));
        }

        size++;
    }

    @Override
    public void removeFromBeginning() {
        if (isEmpty()) {
            return;
        } else {
            root = root.getNext();
        }
        size--;
    }

    @Override
    public void remove(T t) {
        if (isEmpty()) return;

        if (root.getData().compareTo(t) == 0) {
            root = root.getNext();
            size--;
            return;
        }

        if (root.getNext() == null) {
            return;
        }

        Node item = root.getNext();
        Node pre = root;
        while (item.getNext() != null) {
            if (item.getData().compareTo(t) == 0) {
                pre.setNext(item.getNext());
                size--;
                return;
            }
            pre = item;
            item = item.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverseList() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }
        Node item = root;
        System.out.print(item.getData() + " -> ");
        while (item.getNext() != null) {
            System.out.print(item.getNext().getData() + " -> ");
            item = item.getNext();
        }

        System.out.println("");
    }

    /**
     * Interview Question #1:
     *
     * Suppose we have a standard linked list. Construct an in-place
     * (without extra memory) algorithm thats able to find the middle node !
     *
     * without help of size() method
     * */
    @Override
    public T getDataOfMiddleNode() {
        if (isEmpty()) {
            return null;
        }

        Node<T> singleStepItem = root;
        Node<T> doubleStepItem = root;

        while (doubleStepItem != null && doubleStepItem.getNext() != null) {

            singleStepItem = singleStepItem.getNext();
            doubleStepItem = doubleStepItem.getNext().getNext();
        }


        return singleStepItem.getData();
    }

    @Override
    public void reverse() {
        if (isEmpty()) return;

        Node item = root;
        Node nextItem = root.getNext();

        while (nextItem != null) {
            Node temp = nextItem.getNext();
            Node temp2 = nextItem;

            nextItem.setNext(item);

            nextItem = temp;
            item = temp2;
        }
        root.setNext(null);
        root = item;
    }
}

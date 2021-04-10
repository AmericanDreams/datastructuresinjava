package mir.project.bst.impl1;

public class BSTwithLinkedList<T extends Comparable<T>> implements BST<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertChild(root, data);
        }
    }

    private void insertChild(Node<T> node, T data) {
        if (node.data.compareTo(data) > 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
            } else {
                insertChild(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(data);
            } else {
                insertChild(node.right, data);
            }
        }
    }

    @Override
    public T delete(T data) {
        return null;
    }

    @Override
    public void traverse(TraverseType TYPE) {

    }

    @Override
    public T search(T data) {
        return search(root, data);
    }

    private T search(Node<T> node, T data) {
        if (node == null) {
            return null;
        } else if (node.data.compareTo(data) == 0) {
            return node.data;
        } else if (node.data.compareTo(data) > 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }
}

class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
    }
}

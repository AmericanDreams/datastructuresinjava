package mir.project.splaytree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public T find(T data) {
        if (root == null) return null;
        Node<T> item = find(root, data);
        if (item != null) {
            root = item;
            return root.getData();
        }
        return null;
    }

    private Node<T> find(Node<T> node, T data) {
        if (node == null) return null;

        if (node.getData().compareTo(data) == 0) {
            //found
            splay(node);
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            return find(node.getRight(), data);
        } else {
            return find(node.getLeft(), data);
        }
    }

    private void splay(Node<T> node) {
        if (node.getParent() == null) return;

        if (node == node.getParent().getLeft()) {
            splay(rightRotation(node));
        } else {
            splay(leftRotation(node));
        }
    }

    private Node<T> leftRotation(Node<T> node) {
        Node<T> parent = node.getParent();
        Node<T> leftChild = node.getLeft();
        Node<T> grandParent = parent.getParent();

        parent.setRight(leftChild);
        if (leftChild != null) {
            leftChild.setParent(parent);
        }


        parent.setParent(node);
        node.setLeft(parent);
        node.setParent(grandParent);

        if (grandParent != null) {
            if (parent == grandParent.getLeft()) {
                // Old parent was the left child of his parent
                grandParent.setLeft(node);
            } else {
                grandParent.setRight(node);
            }
        }

        return node;
    }

    private Node<T> rightRotation(Node<T> node) {
        Node<T> parent = node.getParent();
        Node<T> rightChild = node.getRight();
        Node<T> grandParent = parent.getParent();

        parent.setLeft(rightChild);
        parent.setParent(node);

        node.setRight(parent);
        node.setParent(grandParent);

        if (grandParent != null) {
            if (parent == grandParent.getLeft()) {
                // Old parent was the left child of his parent
                grandParent.setLeft(node);
            } else {
                grandParent.setRight(node);
            }
        }

        return node;
    }

    @Override
    public T delete(T data) {
        return null;
    }

    @Override
    public void traverse() {
        if (root == null) return;
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeft() != null) inOrderTraversal(node.getLeft());

        System.out.println(node.getData());

        if (node.getRight() != null) inOrderTraversal(node.getRight());
    }

    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            return;
        }

        insert(root, node);
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    private void insert(Node<T> node, Node<T> newNode) {
        if (newNode.getData().compareTo(node.getData()) > 0) {
            //insert to right
            if (node.getRight() != null) {
                insert(node.getRight(), newNode);
            } else {
                newNode.setParent(node);
                node.setRight(newNode);
                return;
            }
        } else {
            //Insert to left
            if (node.getLeft() != null) {
                insert(node.getLeft(), newNode);
            } else {
                newNode.setParent(node);
                node.setLeft(newNode);
                return;
            }
        }
    }
}

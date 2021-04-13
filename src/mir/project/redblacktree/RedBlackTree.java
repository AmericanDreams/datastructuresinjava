package mir.project.redblacktree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {
        if (root != null)
            inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());

        System.out.println(node.getData());

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        root = insertIntoTree(root, node);
        
        fixViolation(node);
    }

    private void fixViolation(Node<T> node) {

        Node<T> grandParent = null;
        Node<T> parent = null;

        while (node != root && node.getColor() == NodeColor.RED && node.getParent().getColor() == NodeColor.RED) {
            grandParent = node.getParent().getParent();
            parent = node.getParent();
            Node<T> uncle = null;
            NodeColor colorOfUncle;

            if (parent == grandParent.getLeftChild()) {
                uncle = grandParent.getRightChild();
            } else {
                uncle = grandParent.getLeftChild();
            }

            if (uncle != null) {
                colorOfUncle = uncle.getColor();
            } else {
                colorOfUncle = NodeColor.BLACK;
            }

            if (parent == grandParent.getLeftChild()) {
                if (node == parent.getRightChild()) {
                    if (colorOfUncle == NodeColor.RED) {
                        //case 1 a
                        //Recoloring
                        recolorSolutionForCase1And4(parent, grandParent, uncle);
                        node = grandParent;
                    } else {
                        //case 2 a
                        //left rotation of parent
                        leftRotation(parent);
                        node = parent;
                    }
                } else {
                    if (colorOfUncle == NodeColor.RED) {
                        //CASE 4 a
                        //Recoloring parent to BLACK, uncle to BLACK and grandparent to RED;
                        recolorSolutionForCase1And4(parent, grandParent, uncle);
                        node = grandParent;
                    } else {
                        //CASE 3 a
                        //First we should Right rotate the grandparent then swap the color of parent and grandfather
                        rightRotation(grandParent);
                        NodeColor temp = parent.getColor();
                        parent.setColor(grandParent.getColor());
                        grandParent.setColor(temp);

                        node = parent;
                    }
                }
            } else {
                // parent is right of its parent

                if (node == parent.getLeftChild()) {
                    if (colorOfUncle == NodeColor.RED) {
                        //case 1 b
                        //Recoloring
                        recolorSolutionForCase1And4(parent, grandParent, uncle);
                        node = grandParent;
                    } else {
                        //case 2 b
                        //left rotation of parent
                        rightRotation(parent);
                        node = parent;
                    }
                } else {
                    if (colorOfUncle == NodeColor.RED) {
                        //CASE 4 b
                        //Recoloring parent to BLACK, uncle to BLACK and grandparent to RED;
                        recolorSolutionForCase1And4(parent, grandParent, uncle);
                        node = grandParent;
                    } else {
                        //CASE 3 b
                        //First we should Right rotate the grandparent then swap the color of parent and grandfather
                        leftRotation(grandParent);
                        NodeColor temp = parent.getColor();
                        parent.setColor(grandParent.getColor());
                        grandParent.setColor(temp);

                        node = parent;
                    }
                }
            }

        }

        if (root.getColor() != NodeColor.BLACK) {
            root.setColor(NodeColor.BLACK);
        }
    }

    private void recolorSolutionForCase1And4(Node<T> parent, Node<T> grandParent, Node<T> uncle) {
        changeColorOfNode(parent, NodeColor.BLACK);
        changeColorOfNode(uncle, NodeColor.BLACK);
        changeColorOfNode(grandParent, NodeColor.RED);
    }

    private void changeColorOfNode(Node<T> node, NodeColor newColor) {
        if (node != null) {
            node.setColor(newColor);
        }
    }

    private Node<T> insertIntoTree(Node<T> rootOfSubtree, Node<T> node) {
        if (rootOfSubtree == null) {
            return node;
        }

        if (node.getData().compareTo(rootOfSubtree.getData()) > 0) {
            rootOfSubtree.setRightChild(insertIntoTree(rootOfSubtree.getRightChild(), node));
            rootOfSubtree.getRightChild().setParent(rootOfSubtree);
        } else {
            rootOfSubtree.setLeftChild(insertIntoTree(rootOfSubtree.getLeftChild(), node));
            rootOfSubtree.getLeftChild().setParent(rootOfSubtree);
        }

        return rootOfSubtree;
    }


    private void leftRotation(Node<T> node) {
        System.out.println("Left Rotation");

        Node<T> tempRightChild = node.getRightChild();
        node.setRightChild(tempRightChild.getLeftChild());

        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }

        tempRightChild.setParent(node.getParent());
        if (tempRightChild.getParent() == null) {
            root = tempRightChild;
        } else if (node == node.getParent().getLeftChild()) {
            node.getParent().setLeftChild(tempRightChild);
        } else if (node == node.getParent().getRightChild()) {
            node.getParent().setRightChild(tempRightChild);
        }

        node.setParent(tempRightChild);
        tempRightChild.setLeftChild(node);
    }

    private void rightRotation(Node<T> node) {
        System.out.println("Right Rotation.");

        Node<T> tempLeftChild = node.getLeftChild();
        node.setLeftChild(tempLeftChild.getRightChild());

        if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }

        tempLeftChild.setParent(node.getParent());

        if (tempLeftChild.getParent() == null) {
            root = tempLeftChild;
        } else if (node == node.getParent().getLeftChild()) {
            node.getParent().setLeftChild(tempLeftChild);
        } else if (node == node.getParent().getRightChild()) {
            node.getParent().setRightChild(tempLeftChild);
        }

        tempLeftChild.setRightChild(node);
        node.setParent(tempLeftChild);
    }




}

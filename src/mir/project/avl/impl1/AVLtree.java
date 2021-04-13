package mir.project.avl.impl1;

public class AVLtree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        
        root = insert(root, data);

    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            System.out.println("Insert " + data);
            return new Node<>(data);
        }
        
        if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        } else {
            node.setLeft(insert(node.getLeft(), data));
        }

        node.setHeight(Math.max(getHeightOf(node.getLeft()), getHeightOf(node.getRight())) + 1);
        
        node = settleViolotion(node, data);
        
        return node;
    }

    private Node<T> settleViolotion(Node<T> node, T data) {
        int balance = getBalanceOf(node);


        if (balance > 1 && data.compareTo(node.getLeft().getData()) < 0) {
            // Case 1: Heavy left left-left
            node = rightRotation(node);
        } else if (balance < -1 && data.compareTo(node.getRight().getData()) > 0) {
            // Case 2: Heavy right right-right
            node = leftRotation(node);
        } else if (balance > 1 && data.compareTo(node.getLeft().getData()) > 0) {
            //Case 3 : left-right
            node.setLeft(leftRotation(node.getLeft()));
            node = rightRotation(node);
        } else if (balance < -1 && data.compareTo(node.getRight().getData()) < 0) {
            //Case 3 : right-left
            node.setRight(rightRotation(node.getRight()));
            node = leftRotation(node);
        }

        return node;
    }

    private Node<T> leftRotation(Node<T> rootNodeOfSubtree) {
        System.out.println("Left Rotation...");

        Node<T> rightOfRoot = rootNodeOfSubtree.getRight();
        Node<T> leftOfRight = rightOfRoot.getLeft();

        rightOfRoot.setLeft(rootNodeOfSubtree);
        rootNodeOfSubtree.setRight(leftOfRight);

        rootNodeOfSubtree.setHeight(Math.max(getHeightOf(rootNodeOfSubtree.getLeft()),
                getHeightOf(rootNodeOfSubtree.getRight())) + 1);

        rightOfRoot.setHeight(Math.max(getHeightOf(rightOfRoot.getLeft()),
                getHeightOf(rightOfRoot.getRight())) + 1);

        return rightOfRoot;
    }

    private Node<T> rightRotation(Node<T> rootNodeOfSubtree) {
        System.out.println("Right Rotation...");

        Node<T> leftNodeTemp = rootNodeOfSubtree.getLeft();
        Node<T> rightOfLeft = leftNodeTemp.getRight();

        leftNodeTemp.setRight(rootNodeOfSubtree);
        rootNodeOfSubtree.setLeft(rightOfLeft);

        rootNodeOfSubtree.setHeight(Math.max(getHeightOf(rootNodeOfSubtree.getLeft()),
                getHeightOf(rootNodeOfSubtree.getRight())) + 1);

        leftNodeTemp.setHeight(Math.max(getHeightOf(leftNodeTemp.getLeft()),
                getHeightOf(leftNodeTemp.getRight())) + 1);

        return leftNodeTemp;
    }

    @Override
    public void traverse() {
        if (root == null) {
            return;
        }

        inOrderTraversal(root);
    }

    @Override
    public T delete(T data) {
        if (root == null) return null;

        return delete(root, data).getData();
    }

    private Node<T> delete(Node<T> node, T data) {

        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), data));
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                // it is leaf
                return null;
            } else if (node.getLeft() == null) {
                // there is right child only
                return node.getRight();
            } else if (node.getRight() == null) {
                // there is only left child
                return node.getLeft();
            } else {
                // there are all child

                Node<T> predecessor = getPredecessor(node);
                node.setData(predecessor.getData());
                node.setLeft(delete(node, predecessor.getData()));

            }
        }
        
        node.setHeight(Math.max(getHeightOf(node.getLeft()), getHeightOf(node.getRight())));
        return settleDeletion(node);
    }

    private Node<T> settleDeletion(Node<T> node) {
        int balance = getBalanceOf(node);
        if (balance > 1) {
            //left
            if (getBalanceOf(node.getLeft()) < 1) {
                // left-right
                node.setLeft(leftRotation(node.getLeft()));;
            }
            // heavy left
            return rightRotation(node);
        } else if (balance < -1) {
            //right
            if (getBalanceOf(node.getRight()) > 1) {
                // right-left
                node.setRight(rightRotation(node.getRight()));
            }
            //heavy right
            return leftRotation(node);
        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        return getBiggest(node.getLeft());
    }

    private Node<T> getBiggest(Node<T> left) {
        if (left.getRight() == null) {
            return left;
        }
        return getBiggest(left.getRight());
    }

    private int getBalanceOf(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return getHeightOf(node.getLeft()) - getHeightOf(node.getRight());
    }

    private int getHeightOf(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());

            System.out.println(node.getData());

            inOrderTraversal(node.getRight());
        }
    }
}

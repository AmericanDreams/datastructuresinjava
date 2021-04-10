package mir.project.bst.impl1;

import mir.project.linkedlist.impl.List;

import java.util.ArrayList;

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
        return delete(null, root, data);
    }

    private T delete(Node<T> parent, Node<T> child, T data) {
        if (child == null) {
            return null;
        } else if (child.data.compareTo(data) == 0) {
            // found
            T temp = child.data;
            if (child.left == null && child.right == null) {
                //The node which we wanna remove is leaf
                if (parent.left == child) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return temp;
            } else if (child.left == null) {
                // there is only right child
                if (parent.left == child) {
                    parent.left = child.right;
                } else {
                    parent.right = child.right;
                }
                return temp;
            } else if (child.right == null) {
                // there is only left child
                if (parent.left == child) {
                    parent.left = child.left;
                } else {
                    parent.right = child.left;
                }
                return temp;
            } else {
                // there are 2 childs
                // find the biggest node on the left subtree
                Node<T> parentOfBig = child;
                Node<T> biggest = child.left;
                while (biggest.right != null) {
                    parentOfBig = biggest;
                    biggest = biggest.right;
                }
                // swapping
                T dataOfBiggest = biggest.data;
                biggest.data = child.data;
                child.data = dataOfBiggest;

                return delete(parentOfBig, biggest, data);
            }
        } else if (child.data.compareTo(data) > 0) {
            return delete(child, child.left, data);
        } else {
            return delete(child, child.right, data);
        }
    }



    @Override
    public void traverse(TraverseType TYPE) {
        switch (TYPE) {
            case IN_ORDER:
                traverseInOrder(root);
                break;
            case PRE_ORDER:
                traversePreOrder(root);
                break;
            case POST_ORDER:
                traversePostOrder(root);
                break;

        }
    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.right);
            traverseInOrder(node.left);
            System.out.println(node.data);
        }
    }

    private void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node.data);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);

            System.out.println(node.data);

            traverseInOrder(node.right);
        }
    }

    @Override
    public T search(T data) {
        return search(root, data);
    }

    @Override
    public T getMin() {
        if (root == null) {
            return null;
        } else {
            return getTheLeftest(root);
        }
    }

    private T getTheLeftest(Node<T> root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getTheLeftest(root.left);
        }
    }

    private T getTheRightest(Node<T> root) {
        if (root.right == null) {
            return root.data;
        } else {
            return getTheLeftest(root.right);
        }
    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        } else {
            return getTheRightest(root);
        }
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    @Override
    public boolean isEqual(BST<T> tree) {
        return isNotesAreEqual(root, tree.getRoot());
    }

    @Override
    public T getKthBiggestValue(int k) {
        if (root == null) {
            return null;
        }

        return getKthBiggestValue(root, k);
    }

    private T getKthBiggestValue(Node<T> node, int k) {
        if (node == null) {
            return null;
        }
        int countOfRightSubTree = getCountOfChildren(node.right);
        if (k == countOfRightSubTree + 1) {
            return node.data;
        } else if (k > countOfRightSubTree + 1) {
            return getKthBiggestValue(node.left, k - countOfRightSubTree - 1);
        } else {
            // k < countOfRightSubTree + 1
            return getKthBiggestValue(node.right, k);
        }
    }

    public int getSum() {
        return getSum(root);
    }

    private int getSum(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return getSum(node.left) + getSum(node.right) + (Integer) node.data;
        }
    }

    private int getCountOfChildren(Node<T> node) {
        if (node != null) {
            int left = getCountOfChildren(node.left);
            int right = getCountOfChildren(node.right);
            return left + right + 1;
        } else {
            return 0;
        }
    }

    private void fillItemsToListSorted(Node<T> node, ArrayList<T> list) {
        if (node != null) {
            fillItemsToListSorted(node.left, list);
            list.add(node.data);
            fillItemsToListSorted(node.right, list);
        }
    }


    private boolean isNotesAreEqual(Node<T> node1, Node<T> node2) {
        if (node1 != null && node2 != null) {
            if (node1.data.compareTo(node2.data) != 0) {
                return false;
            }
            boolean leftSide = isNotesAreEqual(node1.left, node2.left);
            boolean rightSide = isNotesAreEqual(node1.right, node2.right);
            return leftSide && rightSide;
        } else if (node1 == null && node2 == null) {
            return true;
        } else {
            return false;
        }
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

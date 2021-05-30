package mir.project.tst.impl2;

// Associative Array With Ternary Search Tree
public class AAWithTST {
    Node root;

    public boolean putRecursively(String key, Object value) {
        return this.putNode(this.root, key, value, 0);
    }

    public Object getRecursively(String key) {
        if (this.root == null) return null;
        return this.getNode(null, this.root, key, 0);
    }

    public void traverse() {
        this.inOrderTraversal(this.root, "");
    }

    private void inOrderTraversal(Node node, String s) {
        if (node == null) return;

        if (node.isLastLetter) System.out.println(s + node.letter + " : " + node.value);

        if (node.left != null) {
            this.inOrderTraversal(node.left, s);
        }

        if (node.middle != null) {
            this.inOrderTraversal(node.middle, s + node.letter);
        }

        if (node.right != null) {
            this.inOrderTraversal(node.right, s);
        }
    }

    private Object getNode(Node parent, Node node, String key, int index) {
        if (key.length() == index) {
            // should be here
            if (node == null) {
                node = parent;
            }
            if (node != null && node.isLastLetter) {
                return node.value;
            } else {
                return null;
            }
        }

        char letter = key.charAt(index);
        if (letter == node.letter) {
            // it shuld be middle child
            return this.getNode(node, node.middle, key, ++index);
        } else if (letter > node.letter) {
            // it might be right or middle one
            if (node.middle != null && node.middle.letter == letter) {
                // so it is middle
                return this.getNode(node, node.middle, key, ++index);
            } else if (node.right != null && node.right.letter == letter) {
                // so it is right
                return this.getNode(node, node.right, key, ++index);
            } else {
                // it does not exist
                return null;
            }
        } else {
            // it might be left or middle
            if (node.middle != null && node.middle.letter == letter) {
                // so it is middle
                return this.getNode(node, node.middle, key, ++index);
            } else if (node.left != null && node.left.letter == letter) {
                // so it is left
                return this.getNode(node, node.left, key, ++index);
            } else {
                // it does not exist
                return null;
            }
        }
    }

    private boolean putNode(Node node, String key, Object value, int index) {

        if (index == key.length()) {
            // finish
            if (node.isLastLetter) {
                return false;
            } else {
                node.isLastLetter = true;
                node.value = value;
                return true;
            }
        }
        char letter = key.charAt(index);
        Node newNode = new Node(letter);
        if (node == null) {
            // should be inserted as a root
            this.root = newNode;

            return this.putNode(this.root, key, value, 1);
        }

        if (node.middle == null) {
            // should be inserted as a middle node
            node.middle = newNode;
            return this.putNode(node.middle, key, value, ++index);
        } else {
            // compare
            if (node.letter == letter) {
                // go to middle
                return this.putNode(node.middle, key, value, ++index);
            } else if (letter > node.letter) {
                // insert to right
                node.right = newNode;
                return this.putNode(node.right, key, value, ++index);
            } else {
                // insert to left
                node.left = newNode;
                return this.putNode(node.left, key, value, ++index);
            }
        }
    }

    public boolean put(String key, Object value) {
        if (this.root == null) {
            Node node = new Node(key.charAt(0));
            this.root = node;
            if (key.length() == 1) {
                node.value = value;
                return true;
            } else {
                key = key.substring(1);
            }
        }

        Node tempNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            Node node = new Node(letter);
            if (tempNode.middle == null) {
                // create and insert as middle node
                tempNode.middle = node;
                tempNode = tempNode.middle;
                continue;
            }

            if (letter == tempNode.letter) {
                tempNode = tempNode.middle;
            } else if (letter > tempNode.letter) {
                // should be insert as right
                if (tempNode.right == null) {
                    tempNode.right = node;
                }
                tempNode = tempNode.right;
            } else {
                // should be insertas left
                if (tempNode.left == null) {
                    tempNode.left = node;
                }
                tempNode = tempNode.left;
            }
        }


        if (tempNode.isLastLetter) {
            // it means this key already exitis

            return false;
        } else {
            tempNode.isLastLetter = true;
            tempNode.value = value;
            return true;
        }
    }

    public Object get(String key) {
        if (this.root == null) return null;

        Node parent = null;
        Node tempNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);

            if (tempNode == null) return null;

            parent = tempNode;
            if (letter == tempNode.letter) {
                // should go to middle node
                tempNode = tempNode.middle;
            } else if (letter > tempNode.letter) {
                // might be in the right  or in the middle
                if (tempNode.middle != null && tempNode.middle.letter == letter) {
                    tempNode = tempNode.middle;
                } else if (tempNode.right != null && tempNode.right.letter == letter) {
                    tempNode = tempNode.right;
                } else {
                    return null;
                }
            } else {
                // might be in the left or middle
                if (tempNode.middle != null && tempNode.middle.letter == letter) {
                    tempNode = tempNode.middle;
                } else if (tempNode.left != null && tempNode.left.letter == letter) {
                    tempNode = tempNode.left;
                } else {
                    return null;
                }
            }
        }

        if (tempNode == null) {
            tempNode = parent;
        }


        if (tempNode.isLastLetter) {
            return tempNode.value;
        } else {
            return null;
        }


    }
}

class Node {
    char letter;
    Node left;
    Node middle;
    Node right;
    boolean isLastLetter;
    Object value;

    Node(char letter) {
        this.letter = letter;
    }

    Node(char letter, Object value) {
        this.letter = letter;
        this.value = value;
    }
}

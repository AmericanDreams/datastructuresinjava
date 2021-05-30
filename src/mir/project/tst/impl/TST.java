package mir.project.tst.impl;

// Ternary Search tree
public class TST {
    Node root;

    public boolean insert(String key) {
        if (this.root == null) {
            Node node = new Node(key.charAt(0));
            this.root = node;
            if (key.length() == 1) {
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
                // it should be inserted here
                tempNode.middle = node;
                tempNode = tempNode.middle;
                continue;
            }

            if (letter == tempNode.letter) {
                // pass to middle
                tempNode = tempNode.middle;
            } else if (letter > tempNode.letter) {
                // should be inserted as right
                if (tempNode.right == null) {
                    tempNode.right = node;
                }
                tempNode = tempNode.right;
            } else {
                /// should go iserted as left
                if (tempNode.left == null) {
                    tempNode.left = node;
                }
                tempNode = tempNode.left;
            }

        }

        if (tempNode.isLastLetter) {
            return false;
        } else {
            tempNode.isLastLetter = true;
            return true;
        }
    }

    public boolean find(String key) {
        if (this.root == null) {
            return false;
        }

        Node parent = null;
        Node tempNode = this.root;
        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);

            if (tempNode == null) return false;

            parent = tempNode;
            if (tempNode.letter == letter) {
                // might be in the middle

                tempNode = tempNode.middle;
            } else if (letter > tempNode.letter) {
                // might be in the middle or right
                if (tempNode.middle != null && tempNode.middle.letter == letter) {
                    tempNode = tempNode.middle;
                } else if (tempNode.right != null && tempNode.right.letter == letter) {
                    tempNode = tempNode.right;
                } else {
                    return false;
                }
            } else {
                // might be in the middle or left
                if (tempNode.middle != null && tempNode.middle.letter == letter) {
                    tempNode = tempNode.middle;
                } else if (tempNode.left != null && tempNode.left.letter == letter) {
                    tempNode = tempNode.left;
                } else {
                    return false;
                }
            }
        }

        return tempNode == null ? parent.isLastLetter : tempNode.isLastLetter;
    }


}

class Node {
    char letter;
    Node left;
    Node middle;
    Node right;
    boolean isLastLetter;

    Node(char letter) {
        this.letter = letter;
    }
}

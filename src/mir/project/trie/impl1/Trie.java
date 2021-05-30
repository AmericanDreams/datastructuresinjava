package mir.project.trie.impl1;



import java.util.ArrayList;
import java.util.List;

public class Trie {
    Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    boolean insert(String key) {
        key = key.toLowerCase();
        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            Node child = tempNode.getChildByLetter(letter);
            if (child == null) {
                // so there is no child with given letter it should be created
                Node newChild = new Node(letter);
                tempNode.insertChild(newChild);
                tempNode = newChild;
            } else {
                tempNode = child;
            }
        }

        if (tempNode.isLastLetter) {
            // It means there was already this key inside the trie
            // because during insert I never set isLastLetter = true. If I inserted it right now it had to be false
            return false;
        } else {
            // So it means this key never inserted before
            // then lets mark this as lastLetter to avoid to be inserted again
            tempNode.isLastLetter = true;
            return true;
        }
    }


    boolean search(String key) {
        key = key.toLowerCase();
        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            Node child = tempNode.getChildByLetter(letter);
            if (child == null) {
                // So it means it is impossible this key inserted before
                return false;
            } else {
                tempNode = child;
            }
        }

        // Becouse if last char (node) marked as lastLetter it means this key inserted otherwise
        // it is just middle node of other key
        return tempNode.isLastLetter;
    }


    // this method is not perfect because it still keeps that nodes there whi ch is actually useless
    boolean remove(String key) {
        key = key.toLowerCase();
        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            Node child = tempNode.getChildByLetter(letter);
            if (child == null) {
                // So it means it is impossible this key inserted before
                return false;
            } else {
                tempNode = child;
            }
        }

        boolean result = tempNode.isLastLetter;
        tempNode.isLastLetter = false;
        return result;
    }


    List<String> autoComplete(String key) {
        List<String> list = new ArrayList<>();

        Node tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            Node child = tempNode.getChildByLetter(letter);
            if (child == null) return list;
            tempNode = child;
        }

        this.searchForAutoComplete(tempNode, key, list);
        return list;
    }

    private void searchForAutoComplete(Node node, String key, List<String> resultList) {
        if (node == null) return;


        if (!node.isLastLetter) {
            node.getAllChildren().stream().forEach((n) -> {
                this.searchForAutoComplete(n, key + n.letter, resultList);
            });
        } else {
            resultList.add(key);
            node.getAllChildren().stream().forEach((n) -> {
                this.searchForAutoComplete(n, key + n.letter, resultList);
            });
        }
    }

    public String getLongestCommonPrefix() {
        Node tempNode = this.root;
        String prefix = "";

        while (tempNode != null && tempNode.getAllChildren().size() == 1) {
            Node child = tempNode.getAllChildren().get(0);
            prefix += child.letter;
            tempNode = child;
        }

        return prefix;
    }
}

class Node {
    char letter;
    Node[] children;
    boolean isLastLetter;

    Node(char letter) {
        this.letter = letter;
        this.children = new Node[26];
    }

    Node(char letter, boolean isLastLetter) {
        this.letter = letter;
        this.children = new Node[26];
        this.isLastLetter = isLastLetter;
    }

    Node getChildByLetter(char c) {
        int index = c - 'a';
        return this.children[index];
    }

    void insertChild(Node node) {
        int index = node.letter - 'a';
        this.children[index] = node;
    }

    List<Node> getAllChildren() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < children.length; i++) {
            if (this.children[i] != null) {
                list.add(this.children[i]);
            }
        }
        return list;
    }
}

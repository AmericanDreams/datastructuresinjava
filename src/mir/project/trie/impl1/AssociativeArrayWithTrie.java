package mir.project.trie.impl1;

public class AssociativeArrayWithTrie {

    private Node root;

    public AssociativeArrayWithTrie() {
        this.root = new Node(' ');
    }

    public Object insert(String key, Object value) {
        if (key.equals(" ")) {
            if (this.isEmpty()) {
                this.root.value = value;
                return this.root.value;
            } else {
                return null;
            }
        }

        Node result = this.insertNode(this.root, key.toLowerCase().trim(), value);

        return (result == null) ? null : result.value;
    }

    public Object search(String key) {
        if (this.isEmpty()) {
            return null;
        }

        if (key.equals(" ")) {
            // it should be root node
            return this.root.value;
        }

        return this.searchForNode(this.root, key.toLowerCase());
    }

    public Object remove(String key) {
        if (this.isEmpty()) {
            return null;
        }

        if (key.equals(" ")) {
            // root should be removed
            // but lets first check is there any child in the root ?
            Object temp = this.root.value;
            if (this.root.isThereAnyChild()) {
                // great ! it means root is the only element inside the associativeArrayWithTrie
                this.root = null;
                return temp;
            } else {
                // it means root is not the only element inside the associativeArrayWithTrie
                // let's just remove its value then
                this.root.value = null;
                return temp;
            }
        }

        return this.removeNode(null, this.root, key.toLowerCase());
    }

    private Object removeNode(Node parent, Node node, String key) {

        if (key.length() == 1) {
            // lets rome it
            Node child = node.getChildByChar(key.charAt(0));
            if (child == null || child.value == null) {
                return null;
            } else {
                Object temp = child.value;
                // lets check is there any child
                if (child.isThereAnyChild()) {
                    // So we can not touch the node itself . We can only remove its value
                    child.value = null;
                    return temp;
                } else {
                    // it means there is no any child
                    // so we can remove it
                    node.removeChildByChar(key.charAt(0));
                    return temp;
                }
            }
        } else {
            Node child = node.getChildByChar(key.charAt(0));
            if (child == null) {
                return null;
            }
            return this.removeNode(node, child, key.substring(1));
        }

    }



    private Object searchForNode(Node node, String key) {
        if (key.length() == 1) {
            // okay it should be here
            Node result = node.getChildByChar(key.charAt(0));
            return result != null ? node.getChildByChar(key.charAt(0)).value : null;
        } else {
            char letter = key.charAt(0);
            Node child = node.getChildByChar(key.charAt(0));
            if (child == null) {
                // So there is no way the node with given key can be inside the Trie
                return null;
            } else {
                return this.searchForNode(child, key.substring(1));
            }
        }

    }

    private Node insertNode(Node node, String key, Object value) {
        if (key.length() == 1) {
            // should be inserted here
            char letter = key.charAt(0);
            Node child = node.getChildByChar(letter);

            if (child == null) {
                // super! there is no child with given key then insert here
                Node newNode = new Node(letter, value);
                node.insertAsChild(newNode);
                return node.getChildByChar(letter);
            } else {
                if (child.value == null) {
                    // It is also okay. Because it means there is child with letter but it does not store any value
                    // So just add new value here
                    child.value = value;
                    return node.getChildByChar(letter);
                } else {
                    // It means there is already child with the value so it might be dublicate
                    return null;
                }
            }
        } else {
            char letter = key.charAt(0);
            Node child = node.getChildByChar(letter);

            if (child == null) {
                // create the node with given char but without value
                child = new Node(letter);
                node.insertAsChild(child);
            }

            return this.insertNode(child, key.substring(1), value);
        }
    }

    public void traverse(String type) {
        if (type.equals("in-order")) {
            this.inOrderTraverse(this.root);
        }
    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            // only for root node
            if (node.letter == ' ') {
                node.letter = 'a';
            }
            // left children
            for (int i = 0; i < node.letter - 'a'; i++) {
                this.inOrderTraverse(node.getChildByIndex(i));
            }

            if (node.value != null) System.out.println(node.value);
            //System.out.println(node.letter + " = " + node.value);


            // right children
            for (int i = node.letter - 'a'; i < 26; i++) {
                this.inOrderTraverse(node.getChildByIndex(i));
            }


        }
    }

    private boolean isEmpty() {
        return this.root.value == null && !this.root.isThereAnyChild();
    }

    class Node {
        char letter;
        Object value;
        Node[] children;

        Node(char letter) {
            this.letter = letter;
            this.children = new Node[26];
        }

        Node(char letter, Object value) {
            this.letter = letter;
            this.value = value;
            this.children = new Node[26];
        }

        public Node getChildByChar(char c) {
            return this.children[c - 97];
        }

        public void removeChildByChar(char c) {
            this.children[c - 97] = null;
        }

        public void insertAsChild(Node node) {
            this.children[node.letter - 97] = node;
        }

        public Node getChildByIndex(int i) {
            return this.children[i];
        }

        public boolean isThereAnyChild() {
            for (int i = 0; i < 26; i++) {
                if (this.children[i] != null) {
                    return true;
                }
            }
            return false;
        }
    }
}

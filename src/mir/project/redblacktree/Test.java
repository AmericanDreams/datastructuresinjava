package mir.project.redblacktree;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Tree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        tree.insert(4);
        tree.insert(14);
        tree.insert(51);
        tree.insert(881);
        tree.insert(2);

        tree.traverse();
    }
}

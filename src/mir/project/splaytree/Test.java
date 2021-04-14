package mir.project.splaytree;

public class Test {
    public static void main(String[] args) {
        Tree<Integer> tree = new SplayTree<>();
        tree.insert(24);
        tree.insert(12);
        tree.insert(33);
        tree.insert(452);

        //tree.traverse();

        System.out.println(tree.getRoot().getData());
        System.out.println(tree.find(452));
        Node<Integer> root = tree.getRoot();
    }
}

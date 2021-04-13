package mir.project.avl.impl1;

public class Test {
    public static void main(String[] args) {
        Tree<Integer> tree = new AVLtree<>();
        tree.insert(1);
        tree.insert(55);
        tree.insert(22);
        //tree.insert(-6);

        tree.delete(-6);
        tree.delete(1);

        tree.traverse();
    }
}

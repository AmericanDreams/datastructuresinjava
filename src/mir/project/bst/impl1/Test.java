package mir.project.bst.impl1;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BSTwithLinkedList<>();
        bst.insert(4);
        bst.insert(2);
        bst.insert(44);
        bst.insert(456);
        bst.insert(0);
        bst.insert(-1);

        System.out.println(bst.search(4));
        System.out.println(bst.search(44));
        System.out.println(bst.search(-1));
        System.out.println(bst.search(66));
    }
}

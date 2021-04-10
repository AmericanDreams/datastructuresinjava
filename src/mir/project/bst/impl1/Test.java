package mir.project.bst.impl1;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BSTwithLinkedList<>();
        bst.insert(55);
        bst.insert(2);
        bst.insert(44);

        System.out.println(bst.getSum());


//        BST<Integer> bst2 = new BSTwithLinkedList<>();
//        bst2.insert(55);
//        bst2.insert(2);
//        bst2.insert(44);
//        bst2.insert(55);
//
//        System.out.println(bst.isEqual(bst2));

       //System.out.println(bst.getKthBiggestValue(1));
        System.out.println(bst.getKthBiggestValue(2));
        //System.out.println(bst.getKthBiggestValue(3));
        //System.out.println(bst.getKthBiggestValue(4));

//        System.out.println(bst.search(4));
//        System.out.println(bst.search(44));
//        System.out.println(bst.search(-1));
//        System.out.println(bst.search(66));

//        System.out.println(bst.delete(55));
//        System.out.println(bst.delete(2));
//        System.out.println(bst.delete(0));
//        System.out.println(bst.delete(-1));
//        System.out.println(bst.delete(-1));
//        System.out.println(bst.delete(-1));

        //bst.traverse(TraverseType.IN_ORDER);
        //bst.traverse(TraverseType.POST_ORDER);

        //System.out.println(bst.getMax());
        //System.out.println(bst.getMin());
    }
}

package mir.project.linkedlist.impl;

public class Test {

    public static void main(String[] args) {
        List<String> list = new SingleLinkedList<>();
        //list.traverseList();

        list.addToBeginning("4");
        list.addToBeginning("3");
        list.addToBeginning("2");
        list.addToBeginning("1");


//        list.traverseList();
//
//        list.addToEnd("yoo");
//
//        list.traverseList();
//
//        list.remove("salam");
//
//
//        list.traverseList();
//
//        System.out.println(list.size());
//
//        list.removeFromBeginning();
//
//        list.traverseList();

//        System.out.println(list.getDataOfMiddleNode());

        list.traverseList();

        list.reverse();

        list.traverseList();
    }
}

package mir.project.heap.impl;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        HeapWithArray heap = new HeapWithArray();

        heap.insert(12);
        heap.printArray();
        heap.insert(23);
        heap.printArray();
        heap.insert(234);
        heap.printArray();
        heap.insert(152);
        heap.printArray();

        heap.insert(5);
        heap.printArray();

        heap.insert(15);
        heap.printArray();

        //System.out.println(heap.isValidMaxHeap());

        heap.changeItToMixHeap();
        heap.printArray();

//        System.out.println(heap.getBiggestItem());
//        heap.printArray();
//        System.out.println(heap.getBiggestItem());
//        heap.printArray();

//        System.out.println(Arrays.toString(heap.heapSort()));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(1, 20);

        System.out.println(list.get(1));

    }
}

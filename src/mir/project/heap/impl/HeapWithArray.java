package mir.project.heap.impl;

import java.util.Arrays;

public class HeapWithArray {
    private static int CAPACITY = 10;
    private int pointer = 0;
    private int[] array;

    public HeapWithArray() {
        array = new int[CAPACITY];
    }

    public int getBiggestItem() {
        if (pointer == 0) {
            return 0;
        }
        int biggest = array[0];
        int lastItemInTheArray = array[pointer - 1];
        array[pointer - 1] = 0;
        pointer--;
        array[0] = lastItemInTheArray;
        fixViolationsAfterRemoval(0);

        return biggest;
    }

    private void fixViolationsAfterRemoval(int index) {

        if(hasAnyChildren(index)) {
            int parent = array[index];
            int firstChildIndex = 2 * index + 1;
            int secondChildIndex = 2 * index + 2;

            int firstChild = 0;
            int secondChild = 0;

            if (firstChildIndex < pointer) {
                firstChild = array[firstChildIndex];
            }

            if (secondChildIndex < pointer) {
                secondChild = array[secondChildIndex];
            }

            int biggestChildIndex = firstChild > secondChild ? firstChildIndex : secondChildIndex;

            if (parent < array[biggestChildIndex]) {
                //swap
                int temp = array[index];
                array[index] = array[biggestChildIndex];
                array[biggestChildIndex] = temp;
                fixViolationsAfterRemoval(biggestChildIndex);
            }
        }
    }

    private boolean hasAnyChildren(int index) {
        int minChildrenIndex = 2 * index + 1;
        return minChildrenIndex < pointer;
    }

    public void insert(int item) {
        if (pointer < CAPACITY) {
            array[pointer++] = item;

            fixViolations(pointer - 1);
        } else{
            // make the backed array bigger
        }
    }

    private void fixViolations(int index) {
        int item = array[index];

        if (index == 0) {
            return;
        }

        int parentIndex = (index % 2 == 0) ? (index - 2) /2 : (index - 1)/2;
        if (array[parentIndex] < array[index]) {
            // violated
            //swap them
            int temp = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = temp;
            fixViolations(parentIndex);
        }
    }

    public int[] heapSort() {
        if (pointer == 0) return null;

        int[] result = new int[pointer];
        while (pointer > 0) {
            result[pointer - 1] = getBiggestItem();
        }
        return result;
    }

    public int peek() {
        return array[0];
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public boolean isValidMaxHeap() {
        if (pointer == 0) return true;

        return checkViolationsFromTopToButton(0);
    }

    private boolean checkViolationsFromTopToButton(int index) {
        int firstChildIndex = 2 * index + 1;
        int secondChildIndex = 2 * index + 2;

        if (firstChildIndex < pointer) {
            if (array[index] < array[firstChildIndex]) {
                return false;
            }

            return checkViolationsFromTopToButton(firstChildIndex);
        }

        if (secondChildIndex < pointer) {
            if (array[index] < array[secondChildIndex]) {
                return false;
            }

            return checkViolationsFromTopToButton(secondChildIndex);
        }

        return true;
    }

    public void changeItToMixHeap() {
        for (int i = pointer - 1; i >= 0; i--) {
            if (2 * i + 1 < pointer) {
                fixMinHeapViolation(i);
            }
        }
    }



    private void fixMinHeapViolation(int index) {
        int firstChildIndex = 2 * index + 1;
        int secondChildIndex = 2 * index + 2;

        int firstChild = firstChildIndex < pointer ? array[firstChildIndex] : array[index];
        int secondChild = secondChildIndex < pointer ? array[secondChildIndex] : array[index];

        int smallestItemIndex = firstChild < secondChild ? firstChildIndex : secondChildIndex;
        if (smallestItemIndex < pointer && array[index] > array[smallestItemIndex]) {
            //swapping
            int temp = array[index];
            array[index] = array[smallestItemIndex];
            array[smallestItemIndex] = temp;
        }

        if (firstChildIndex < pointer) {
            fixMinHeapViolation(firstChildIndex);
        }

        if (secondChildIndex < pointer) {
            fixMinHeapViolation(secondChildIndex);
        }

    }
}

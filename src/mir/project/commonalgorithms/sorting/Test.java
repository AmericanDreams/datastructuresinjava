package mir.project.commonalgorithms.sorting;

import mir.project.commonalgorithms.sorting.bogo.BogoSort;
import mir.project.commonalgorithms.sorting.bubble.BubbleSort;
import mir.project.commonalgorithms.sorting.insertion.InsertionSort;
import mir.project.commonalgorithms.sorting.quicksort.QuickSort;
import mir.project.commonalgorithms.sorting.selection.SelectionSort;
import mir.project.commonalgorithms.sorting.shell.ShellSort;

public class Test {
    public static void main(String[] args) {
        int[] nums = {66, 3, 44, 2, 0, 44, 8};
//        BogoSort bogoSort = new BogoSort(nums);
//        bogoSort.sort();


//        BubbleSort bubbleSort = new BubbleSort(nums);
//        bubbleSort.sort();

//        SelectionSort selectionSort = new SelectionSort(nums);
//        selectionSort.sort();

//        InsertionSort insertionSort = new InsertionSort(nums);
//        insertionSort.sort();

//        ShellSort shellSort = new ShellSort(nums);
//        shellSort.sort();

        QuickSort quickSort = new QuickSort(nums);
        quickSort.sort();
    }
}

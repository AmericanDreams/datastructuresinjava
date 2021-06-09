package mir.project.commonalgorithms.sorting.quicksort;

public class QuickSort {
    private int[] nums;

    public QuickSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        quickSort(0, nums.length - 1);

        printArray();
    }

    private void quickSort(int start, int end) {
        if (end < start) return;

        int pivotIndex = partition(start, end);
        quickSort(start, pivotIndex - 1);
        quickSort(pivotIndex + 1 , end);
    }


    private int partition(int start, int end) {
        //int randomIndex = randomInRange(start, end - 1); it is also choise
        int randomIndex = (end + start) /2;
        swap(randomIndex, end);

        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[end]) {
                swap(start, i);
                start++;
            }
        }
        swap(end, start);

        return start;
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int randomInRange(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

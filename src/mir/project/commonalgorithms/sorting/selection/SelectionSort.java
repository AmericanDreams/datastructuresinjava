package mir.project.commonalgorithms.sorting.selection;

public class SelectionSort {
    private int[] nums;

    public SelectionSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int k = i + 1;
            for (; k < nums.length; k++) {
                if (nums[k] < nums[minIndex]) {
                    minIndex = k;
                }
            }
            swap(i, minIndex);
        }

        printArray();
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

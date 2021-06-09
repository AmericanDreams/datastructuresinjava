package mir.project.commonalgorithms.sorting.bubble;

public class BubbleSort {

    private int[] nums;

    public BubbleSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int k = 1; k <= i; k++) {
                if (firstGreaterThanSecond(nums[k-1], nums[k])) {
                    swap(k-1, k);
                }
            }
        }

        printArray();
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private boolean firstGreaterThanSecond(int first, int second) {
        return first > second;
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

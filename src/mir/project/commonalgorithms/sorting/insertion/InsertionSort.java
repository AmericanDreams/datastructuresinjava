package mir.project.commonalgorithms.sorting.insertion;

public class InsertionSort {
    private int[] nums;

    public InsertionSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            int k = i - 1;
            while (k >= 0 && nums[k] > number) {
                //shift k to right
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = number;
        }

        printArray();
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

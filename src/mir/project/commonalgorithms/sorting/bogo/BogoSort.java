package mir.project.commonalgorithms.sorting.bogo;

public class BogoSort {
    private int[] nums;
    private int counter;

    public BogoSort(int[] nums) {
        this.nums = nums;
    }

    // O(N!)
    public void sort() {
        while (!isSorted()) {
            counter++;
            shuffle();
        }
        System.out.println(counter + " permutation");
        printArray();
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // Fisher-Yates shuffle algorithm O(N)
    private void shuffle() {
        for (int i = nums.length - 1; i >= 0; i--) {
            int gen = (int) (Math.random() * i); // 0 <= gen <= i
            swap(i, gen);
        }
    }

    //O(1)
    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //O(N)
    private boolean isSorted() {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) return false;
        }
        return true;
    }
}

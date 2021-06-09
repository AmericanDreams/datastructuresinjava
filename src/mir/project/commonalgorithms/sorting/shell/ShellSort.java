package mir.project.commonalgorithms.sorting.shell;

public class ShellSort {
    private int[] nums;

    public ShellSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        for (int step = nums.length / 2; step > 0; step = step/2) {
            for (int start = 0; start < step; start++) {
                for (int i = start + step; i < nums.length; i+=step) {
                    int number = nums[i];
                    int k = i - step;
                    while (k >= 0 && nums[k] > number) {
                        //shift k to right
                        nums[k + step] = nums[k];
                        k-=step;
                    }
                    if (k + step != i)
                        nums[k + step] = number;
                }
            }
        }

        printArray();
    }

    private void printArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

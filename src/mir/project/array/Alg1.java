package mir.project.array;

import java.util.Arrays;

public class Alg1 {

    /**
     * Interview Question #1
     *
     * The problem is that we want to reverse a T[] array in O(N) linear time complexity and we want the algorithm to be in-place as well!
     *
     * For example: input is [1,2,3,4,5] then the output is [5,4,3,2,1]
     * */

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int item = array[i];
            int newIndex = array.length - i - 1;
            int temp = array[newIndex];
            array[newIndex] = item;
            array[i] = temp;
        }
    }


}

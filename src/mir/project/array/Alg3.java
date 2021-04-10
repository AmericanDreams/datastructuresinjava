package mir.project.array;

import java.util.Arrays;
import java.util.HashSet;

public class Alg3 {

    /**
     * Interview Question #3
     *
     * The problem is that we want to find duplicates in a T[] one-dimensional array of
     * integers in O(N) running time where the integer values are smaller than the length and
     * of the array and all of them are positive!
     *
     * */

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 3, 4, 0, 1, -6};
        Integer[] dubs = findDubs(array);

        System.out.println(Arrays.toString(dubs));

    }

    private static Integer[] findDubs(int[] array) {
        HashSet<Integer> dubs = new HashSet<>(array.length);

        // O (N * logn)
        Arrays.sort(array);

        // O(N)
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i+1]) {
                dubs.add(array[i]);
                i++;
            }
        }

        // Total O(N * logn)
        return dubs.toArray(new Integer[1]);
    }
}

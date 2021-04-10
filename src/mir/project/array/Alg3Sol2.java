package mir.project.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alg3Sol2 {

    /**
     * Interview Question #3
     *
     * The problem is that we want to find duplicates in a T[] one-dimensional array of
     * integers in O(N) running time where the integer values are smaller than the length and
     * of the array and all of them are positive!
     *
     * */

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 3, 4, 0, 1};
        Integer[] dubs = findDubs(array);

        System.out.println(Arrays.toString(dubs));

    }

    private static Integer[] findDubs(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);

        //O (N)
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            if (array[Math.abs(item)] > 0) {
                array[Math.abs(item)] = -array[Math.abs(item)];
            } else {
                list.add(Math.abs(item));
            }
        }

        // Total  =  O(N)
        return list.toArray(new Integer[1]);
    }
}

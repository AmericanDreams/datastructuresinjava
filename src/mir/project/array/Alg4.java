package mir.project.array;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Alg4 {

    /**
     * Interview Question #4:
     *
     * Our task is to design an algorithm that is capable of selecting k items from an array!
     * The problem is that the n size of the array is unknown (or infinitely large)!
     *
     * Solution: we can solve this problem with the so-called reservoir sampling algoirthm! Check it out!
     *
     * */

    public static void main(String[] args) {
        int[] array = {1,2,-44,56,4,23,55,-789,12,23,44,-345,5,567,21,54,987};
        int[] selective = selectRandomItemsFromArrayWithGivenCount(array, 5);

        System.out.println(Arrays.toString(selective));;
    }

    private static int[] selectRandomItemsFromArrayWithGivenCount(int[] array, int k) {
        //Reservoir sampling algoirthm

        int[] result = Arrays.copyOfRange(array, 0, k);

        for (int i = k + 1 ; i < array.length; i++) {
            int ramdom = new Random().nextInt(i) + 1;
            if (ramdom < k) {
                result[ramdom] = array[i];
            }
        }

        return result;
    }
}

package mir.project.array;

import java.util.Arrays;

public class Alg2Sol2 {
    /**
     * Interview Question #2:
     *
     * Construct an algorithm to check whether two words (or phrases) are anagrams or not!
     *
     * "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once"
     * */


    public static void main(String[] args) {
        String word = "Sal  am";
        String word2 = "M     alSa";

        System.out.println(isAnagrams(word, word2));
    }

    private static boolean isAnagrams(String word, String word2) {
        char[] word1Chars = word.toCharArray();
        char[] word2Chars = word2.toCharArray();

        // O(N * logN)
        sort(word1Chars);

        // O(N * logN)
        sort(word2Chars);

        // O(N)
        for (int i = 0, j = 0; i < word1Chars.length && j < word2Chars.length; ) {
            char c1 = word1Chars[i];
            char c2 = word1Chars[i];

            if (Character.isSpaceChar(c1)) {
                i++;
                continue;
            }

            if (Character.isSpaceChar(c2)) {
                j++;
                continue;
            }


            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            i++;
            j++;
        }

        // Total O is equal to O (NlogN + NlogN + N) about O(N * logN)
        return true;
    }

    private static void sort(char[] word1Chars) {
        Arrays.sort(word1Chars);
    }
}

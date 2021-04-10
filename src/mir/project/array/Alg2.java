package mir.project.array;

public class Alg2 {

    /**
     * Interview Question #2:
     *
     * Construct an algorithm to check whether two words (or phrases) are anagrams or not!
     *
     * "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once"
     * */


    public static void main(String[] args) {
        String word = "Salm";
        String word2 = "MalSa";

        System.out.println(isAnagrams(word, word2));
    }

    private static boolean isAnagrams(String word, String word2) {
        char[] word1Chars = word.toCharArray();
        char[] word2Chars = word2.toCharArray();

        // O(N)
        for (char c : word1Chars) {
            if (Character.isSpaceChar(c)) {
                continue;
            }
            // O(N)
            int index = findInArrayCaseInSensitive(c , word2Chars);
            if (index == -1) {
                return false;
            } else {
                word2Chars[index] = ' ';
            }
        }

        // O(N)
        for (char c :  word2Chars) {
            if (!Character.isSpaceChar(c)) {
                return false;
            }
        }

        // Total O (N2 + N) about O(N power of 2) O(N2)

        return true;
    }

    private static int findInArrayCaseInSensitive(char c, char[] word2Chars) {
        c = Character.toLowerCase(c);

        for (int i = 0; i < word2Chars.length; i++) {
            if (c == Character.toLowerCase(word2Chars[i])) {
                return i;
            }
        }

        return -1;
    }
}

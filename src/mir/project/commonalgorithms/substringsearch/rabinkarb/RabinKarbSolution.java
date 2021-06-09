package mir.project.commonalgorithms.substringsearch.rabinkarb;

public class RabinKarbSolution {
    public static void main(String[] args) {
        System.out.println(subString("salam", "lam"));
    }

    //With very Simple rollish hashing function
    private static int subString(String text, String pattern) {
        int hashOfPattern = hash(pattern, 0, pattern.length()-1);
        int hashOfText = 0;

        for (int i = 0; i < text.length(); i++) {

            if (i == 0) {
                // First iteration
                hashOfText = hash(text, i, i + pattern.length() - 1);
            } else {
                hashOfText = hashOfText - text.charAt(i-1) + text.charAt(i + pattern.length() - 1);
            }

            if (hashOfPattern == hashOfText) {
                int j = 0;
                for (; j < pattern.length(); j++) {
                    if (pattern.charAt(j) != text.charAt(i + j)) break;
                }

                if (j == pattern.length()) return i;
            }

        }
        return -1;
    }

    private static int hash(String text, int start, int end) {
        int result = 0;
        for (; start <= end; start++) {
            result += text.charAt(start);
        }
        return result;
    }
}

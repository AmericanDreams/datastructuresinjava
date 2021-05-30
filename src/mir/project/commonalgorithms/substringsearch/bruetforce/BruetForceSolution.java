package mir.project.commonalgorithms.substringsearch.bruetforce;

public class BruetForceSolution {

    public static void main(String[] args) {
        System.out.println(subString("salam", "lam"));
    }

    // O(N * M) ; N = text.length(), M = pattern.length()
    private static int subString(String text, String pattern) {
       for (int i = 0; i <= text.length() - pattern.length(); i++) {
           int j;

           for (j = 0; j < pattern.length(); j++) {
               if (text.charAt(i + j) != pattern.charAt(j)) break;
           }

           if (j == pattern.length()) return i;
       }
       return -1;
    }
}

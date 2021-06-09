package mir.project.commonalgorithms.substringsearch.knuthmorrispratt;

import java.util.Arrays;

public class KMPSolution {
    public static void main(String[] args) {
        System.out.println(subString("salam", "lam"));
    }


    // The wors case is O(M+N); But algorith is not in-place. We need to create p table for pattern
    private static int subString(String text, String pattern) {
        int[] pTableForPattern = createPiTable(pattern);

        int t = 0, p = 0;
        for (;t < text.length() && p < pattern.length(); ) {
            if (text.charAt(t) == pattern.charAt(p)) {
                t++;
                p++;
            } else {
                int piTableIndex = Math.max(p, 0);
                int pi = pTableForPattern[piTableIndex];
                p = pi;
                if (p == 0) t++;
            }
        }

        if (p == pattern.length()) {
            return t - pattern.length();
        }
        return -1;
    }

    // O(M); M = text.length()
    private static int[] createPiTable(String text) {
        int[] table = new int[text.length()];
        int match = -1;
        for (int i = 1; i < text.length();) {
            if (text.charAt(i) == text.charAt(match + 1)) {
                table[i] = match + 1 ;
                match++;
                i++;
            } else {
                if (match == -1) i++;
                match = -1;
            }
        }
        return table;
    }
}

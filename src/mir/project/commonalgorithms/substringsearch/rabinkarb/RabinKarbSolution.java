package mir.project.commonalgorithms.substringsearch.rabinkarb;

public class RabinKarbSolution {
    public static void main(String[] args) {
        System.out.println(subString("salam", "lam"));
    }

    // O(N * M) ; N = text.length(), M = pattern.length()
    private static int subString(String text, String pattern) {
        if (text.length() < pattern.length()) return -1;

        double patternHash = hash(pattern);
        double hash = 0;
        OUTER: for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (i == 0) {
                hash = hash(text.substring(0, pattern.length()));
            } else {
                hash = (hash - hash(text.substring(i - 1, i)) * Math.pow(2, pattern.length()-1)) * 2 +
                        hash(text.substring(i+pattern.length() - 1, i+pattern.length()));
            }

            if (hash == patternHash) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) continue OUTER;
                }
                return i;
            }
        }
        return -1;
    }

    private static double hash(String text) {
        double hash = 0;
        for (int i = 0, j = text.length() - 1; i < text.length(); i++, j--) {
            hash += text.charAt(i) * Math.pow(2, j);
        }
        return hash;
    }
}

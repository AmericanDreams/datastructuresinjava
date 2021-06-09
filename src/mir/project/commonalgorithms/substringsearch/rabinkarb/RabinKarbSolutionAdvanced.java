package mir.project.commonalgorithms.substringsearch.rabinkarb;

public class RabinKarbSolutionAdvanced {

    private static final int PRIME = 5;

    public static void main(String[] args) {
        System.out.println(subString("alamas", "lam"));
    }

    // Avareage time O(M+N) , The wors is (M*N); M = text.length(), M = pattern.length();
    private static int subString(String text, String pattern) {
        final int PATTERN_LENGTH = pattern.length();
        double hashOfPattern = 0;
        double hashOfText = 0;

        for (int p = pattern.length() - 1,i = 0; p >= 0 && i < pattern.length(); p--, i++) {
            hashOfPattern = (hashOfPattern + pattern.charAt(i) * Math.pow(PRIME, p)) % 31;
            hashOfText = (hashOfText + text.charAt(i) * power(PRIME, p)) % 31;
        }

        double largestpolynomial = power(PRIME, pattern.length()-1);

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (i > 0)  {
                hashOfText = createNewHashBasedOnOld(hashOfText, text.charAt(i-1) * largestpolynomial, text.charAt(i + PATTERN_LENGTH - 1));
            }

            if (hashOfPattern == hashOfText) {
                int j = 0;
                for (; j < PATTERN_LENGTH; j++) {
                    if (pattern.charAt(j) != text.charAt(i + j)) break;
                }

                if (j == PATTERN_LENGTH) return i;
            }
        }

        return -1;
    }

    private static double createNewHashBasedOnOld(double hash, double subtraction, double addition) {
        double newHash = ((hash - subtraction) * PRIME + addition) % 31;
        if (newHash < 0) newHash += 31;
        return newHash;
    }

    private static double power(int number, int power) {
        if (power == 0) return 1;

        double result = 1;

        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        return result;
    }
}

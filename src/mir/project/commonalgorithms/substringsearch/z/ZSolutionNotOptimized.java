package mir.project.commonalgorithms.substringsearch.z;

public class ZSolutionNotOptimized {
    public static void main(String[] args) {
        System.out.println(subString("bbbaa", "aa"));
    }


    private static int subString(String text, String pattern) {

        // Creating the Z table
        int[] zTable = new int[text.length() + pattern.length()];
        String concat = pattern + text;
        // abadcaba
        int length = 0;
        int l = 0, r = pattern.length();
        for (; r < concat.length();) {
            if (r + length < concat.length()) {
                if (concat.charAt(l + length) == concat.charAt(r + length)) {
                    length++;
                } else {
                    zTable[r] = Math.max(length, 0);
                    length = 0;
                    r++;
                }
            } else {
                zTable[r] = Math.max(length, 0);
                length = 0;
                r++;
            }
        }

        for (int index = 0; index < zTable.length; index++) {
            if (zTable[index] >= pattern.length()) {
                return index - pattern.length();
            }
        }

        return -1;
    }
}

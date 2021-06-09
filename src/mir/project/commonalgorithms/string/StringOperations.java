package mir.project.commonalgorithms.string;

public class StringOperations {

    // O(N); N = text.length();
    public static String reverseString(String text) {
        StringBuilder builder = new StringBuilder(text.length());
        for (int i = text.length() - 1; i >= 0; i--) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    // O(N); N = text.length();
    public static String[] getSuffixes(String text) {
        String[] result = new String[text.length()];
        for (int i = text.length() - 1, index = 0; i >= 0; i--, index++) {
            result[index] = text.substring(i);
        }
        return result;
    }

    // O(N); N = text.length();
    public static String[] getPrefixes(String text) {
        String[] result = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.substring(0, i+1);
        }
        return result;
    }

    // O(N); N = Math.min(text1.length(), text2.length())
    public static String getLongestCommonPrefix(String text1, String text2) {
        int t1 = 0, t2 = 0;
        for (; t1 < text1.length() && t2 < text2.length(); t1++, t2++) {
            if (text1.charAt(t1) != text2.charAt(t2)) break;
        }

        return text1.substring(0, t1);
    }

    //aacvbaadc
    //a
    //aa a




    //a  aa aac aacv
    //a  ac acv acvb
    //c  cv cvb
    //v  vb vba
    //b  ba baa
    //a  aa aad aadc
    public static String getLongestRepeatedSubString(String text) {
        String result = "";
        int length = 1;
        for (int index = 0; index < text.length(); index++) {
            for (int j = 1; j < text.length();) {
                if (index + length <= j && index + length <= text.length() && j + length <= text.length() &&
                        text.substring(index, index + length).equals(text.substring(j, j + length))) {
                    length++;
                } else {
                    if (length != 1) {
                        String match = text.substring(j, j + length - 1);
                        if (match.length() > result.length()) result = match;
                    }
                    j++;
                    length = 1;
                }
            }
        }
        return result;
    }
}

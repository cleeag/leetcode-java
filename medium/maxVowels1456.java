import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class maxVowels1456 {
    public static void main(String[] args) {
//        String s = "abciiidef";
//        int k = 3;
//
//        String s = "aeiou";
//        int k = 2;
//
//        String s = "rhythms";
//        int k = 4;
//        String s = "weallloveyou";
//        int k = 7;
        String s = "novowels";
        int k = 1;


        maxVowels1456 tmp = new maxVowels1456();
        System.out.println(tmp.maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int i = 0, vowels = 0, ans = 0;
        while (i < s.length() && !vowelSet.contains(s.charAt(i))) i++;
        int j = i;

        while (i < s.length() && j < s.length()) {
            if (j - i == k) {
                vowels--;
                i++;
                while (i < s.length() && !vowelSet.contains(s.charAt(i))) {
                    i++;
                }
            }
            if (vowelSet.contains(s.charAt(j))) vowels++;
            ans = Math.max(ans, vowels);
            System.out.println(i + " " + j + " " + ans + " " + vowels + " " + s.charAt(j));
            j++;
        }

        return ans;
    }
}

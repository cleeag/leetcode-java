public class longestPalindromeSubseq516 {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0)
            return 0;

        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, Math.max(findMax(s, i, i), findMax(s, i, i + 1)));
        }
        return max;
    }

    public int findMax(String s, int i, int j) {
        int len = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (j == i) len +=  1;
            else len += 2;
            i--;
            j++;
        }
        // System.out.println(len);
        return len;
    }
}

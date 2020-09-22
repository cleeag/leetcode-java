public class characterReplacement424 {
    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;
        String s = "AABABBA";
        int k = 3;
//        String s = "EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH";
//        int k = 7;
//        String s ="IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR";
//        int k = 2;
        characterReplacement424 tmp = new characterReplacement424();
        tmp.characterReplacement(s, k);
    }

    public int characterReplacement(String s, int k) {
        int[] alphs = new int[26];
        for (int i = 0; i < s.length(); i++) alphs[s.charAt(i) - 'A'] = 1;

        int n = s.length();
        int maxLen = 0;
        for (int l = 0; l < 26; l++) {
            if (alphs[l] == 0) continue;
            char c = (char) ('A' + l);
            int i = 0, j = 0;
            int replacement = k;
            while (j < n) {
                if (replacement < 0) {
                    while (i < j && s.charAt(i) == c) i++;
                    while (i < j && s.charAt(i) != c) {
                        i++;
                        if (replacement < k) replacement++;
                    }
                }
                if (s.charAt(j) != c) replacement--;
                if (replacement == 0) maxLen = Math.max(maxLen, j - i + 1);
                j++;
                System.out.println(c + " " + s.charAt(i) + " " + i + " " + j + " " + replacement + " " + maxLen);
            }
            if (replacement >= 0) maxLen = Math.max(maxLen, j - i);
        }
        System.out.println(maxLen);
        return maxLen;
    }
}

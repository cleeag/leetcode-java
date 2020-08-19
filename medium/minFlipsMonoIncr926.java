import java.util.Arrays;

public class minFlipsMonoIncr926 {
    public static void main(String[] args) {
        String s = "00011000";
//        String s = "010110";
//        String s = "11011";
        minFlipsMonoIncr926 tmp = new minFlipsMonoIncr926();

        tmp.minFlipsMonoIncr(s);
    }

    public int minFlipsMonoIncr(String S) {
        if (S.length() <= 1) return 0;
        int n = S.length();
        int[] flip = new int[n];
        int[] noFlip = new int[n];
        flip[0] = 1;
        noFlip[0] = 0;
        for (int i = 1; i < S.length(); i++) {
            int min = Math.min(flip[i - 1], noFlip[i - 1]);
            if (S.charAt(i) == '1') {
                noFlip[i] = min;
                if (S.charAt(i - 1) == '1') flip[i] = flip[i - 1] + 1;
                else flip[i] = noFlip[i - 1] + 1;
            } else {
                flip[i] = min + 1;
                if (S.charAt(i - 1) == '1') noFlip[i] = flip[i - 1];
                else noFlip[i] = noFlip[i - 1];
            }
        }
        return Math.min(flip[n - 1], noFlip[n - 1]);
    }
}

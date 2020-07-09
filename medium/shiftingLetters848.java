import java.util.Arrays;

public class shiftingLetters848 {
    public static void main(String[] args) {
        String s = "abc";
        int[] sh = new int[] {3, 5, 9};
        shiftingLetters848 tmp = new shiftingLetters848();
        System.out.println(tmp.shiftingLetters(s, sh));
    }
    public String shiftingLetters(String S, int[] shifts) {
        if (shifts.length == 0) return S;

        int[] newShift = new int[shifts.length];
        newShift[shifts.length-1] = shifts[shifts.length-1];
        for (int i = shifts.length-2; i >=0 ; i--) newShift[i] = (shifts[i] + newShift[i + 1]) % 26;
        System.out.println(Arrays.toString(newShift));

        char a = 'a';
        String ans = "";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            c = (char)(a + (c - a + newShift[i]) % 26);
            ans += c;
        }

        return ans;
    }
}

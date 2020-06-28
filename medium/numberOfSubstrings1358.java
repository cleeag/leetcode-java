public class numberOfSubstrings1358 {
    public static void main(String[] args) {
        numberOfSubstrings1358 tmp = new numberOfSubstrings1358();
//        String s = "abcabc";
        String s = "aaabc";
        tmp.numberOfSubstrings(s);
    }
    public int numberOfSubstrings(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int cPointer = 0;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aPointer = i + 1;
            if (s.charAt(i) == 'b') bPointer = i + 1;
            if (s.charAt(i) == 'c') cPointer = i + 1;

            if (aPointer != 0 && bPointer != 0 &&cPointer != 0)
                ans += Math.min(aPointer, Math.min(bPointer, cPointer));
            System.out.println(aPointer + " " + bPointer + " " + cPointer);
            System.out.println(ans);
            System.out.println();
        }
        return ans;
    }
}

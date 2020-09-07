public class numWays1573 {
    public static void main(String[] args) {
//        String s = "100100010100110";
//        String s = "0000";
        String s = "101010";
        numWays1573 tmp = new numWays1573();
        System.out.println(tmp.numWays(s));
    }

    public int numWays(String s) {
        double mod = 1e9 + 7;
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') nums = (int) ((nums + 1) % mod);
        }
        if (nums % 3 != 0) return 0;
        else if (nums == 0) {
            int space = (int) ((s.length() - 1) % mod);
            System.out.println(space);
            return (int) (((space % mod) * ((space - 1) % mod)) % mod) / 2;
        }

        int count = 0;
        int firstStart = -1, firstEnd = -1, secondStart = -1, secondEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count = (int) ((count + 1) % mod);
            if (count == nums / 3 && firstStart == -1) firstStart = i;
            if (count == nums / 3 + 1 && firstEnd == -1) firstEnd = i;
            if (count == nums / 3 * 2 && secondStart == -1) secondStart = i;
            if (count == nums / 3 * 2 + 1 && secondEnd == -1) secondEnd = i;
        }
        System.out.println(firstStart + " " + firstEnd + " " + secondStart + " " + secondEnd);
        return (int) ((((firstEnd - firstStart) % mod) * ((secondEnd - secondStart) % mod)) % mod);
    }
}

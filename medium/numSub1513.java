public class numSub1513 {
    public static void main(String[] args) {
        String s = "0110111";
        numSub1513 tmp = new numSub1513();
        tmp.numSub(s);
    }
    public int numSub(String s) {
        int ans = 0;
        int roll = 0;
        double mod =  1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') roll++;
            else if (s.charAt(i) == '0') roll = 0;
            roll %= mod;
            ans += roll;
            ans %= mod;
        }
        System.out.println(ans);
        return ans;
    }
}

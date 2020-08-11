public class findKthBit1545 {
    public static void main(String[] args) {
        findKthBit1545 tmp = new findKthBit1545();
        tmp.findKthBit(2, 3);
    }
    public char findKthBit(int n, int k) {
        int round = 0;
        StringBuilder sb = new StringBuilder("0");
        StringBuilder newSb = new StringBuilder();
        while (round < n){
            newSb = new StringBuilder(sb.toString());
            newSb.append("1");
            for (int i = sb.length()-1; i >=0; i--) {
                if (sb.charAt(i) == '1') newSb.append("0");
                else newSb.append("1");
            }
            sb = newSb;
            round++;
//            System.out.println(sb);
        }
        return newSb.charAt(k-1);
    }
}

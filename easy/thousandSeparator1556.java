public class thousandSeparator1556 {
    public static void main(String[] args) {
//        int n = 987;
//        int n = 123456789;
        int n = 2;
        thousandSeparator1556 tmp = new thousandSeparator1556();
        tmp.thousandSeparator(n);

    }
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n > 0){
            if (count == 3){
                sb.insert(0, '.');
                count = 0;
            }
            int cur = n % 10;
            sb.insert(0, (char)(cur + 48));
            count++;
            n /= 10;
            System.out.println(sb);
        }
        System.out.println(sb);
        return sb.toString();
    }
}

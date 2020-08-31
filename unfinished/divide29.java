public class divide29 {
    public static void main(String[] args) {
        int d = 10, v = 3;
//        int d = 7, v = -3;
        divide29 tmp = new divide29();
        System.out.println(tmp.divide(d, v));
    }

    public int divide(int dividend, int divisor) {
        int orgDividend = dividend, orgDivisor = divisor;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        if (divisor == 1) return orgDividend < 0 != orgDivisor < 0 ? -dividend : dividend;
        int lo = 0, hi = dividend;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            System.out.println(lo + " " + hi + " " + mid);
            if (divisor * mid > dividend) hi = mid - 1;
            else if (divisor * mid < dividend) lo = mid + 1;
            else return orgDividend / orgDivisor < 0 ? -mid : mid;
        }
        int ans;
        if (divisor * hi < dividend) ans = hi;
        else ans = lo;
        System.out.println(dividend / divisor);
        return orgDividend / orgDivisor < 0 ? -ans : ans;
    }
}

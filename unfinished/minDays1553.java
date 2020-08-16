import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class minDays1553 {
    public static void main(String[] args) {
        minDays1553 tmp = new minDays1553();
//        System.out.println(tmp.minDays(28));
        System.out.println(tmp.minDays(56));
//        System.out.println(tmp.minDays(10));
//        System.out.println(tmp.minDays(25));
    }

    public int minDays(int n) {
        System.out.println(n);
        if (n == 1) return 1;
        if (n == 0) return 0;
        return Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)) + 1;
    }


}

import java.util.Arrays;
import java.util.Stack;

public class asteroidCollision735 {
    public static void main(String[] args) {
        asteroidCollision735 tmp = new asteroidCollision735();
//        int[] a = new int[]{5, 10, -5};
//        int[] a = new int[]{8, -8};
//        int[] a = new int[]{10, 2, -5};
        int[] a = new int[]{-2, -1, 1, 2};
        tmp.asteroidCollision(a);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int asteroid : asteroids) {
            boolean boom = false;
            while (s.size() > 0 && s.peek() > 0 && asteroid < 0) {
                System.out.println(s);
                if (-asteroid > s.peek()) s.pop();
                else {
                    if (-asteroid == s.peek()) {
                        s.pop();
                    }
                    boom = true;
                    break;
                }
                System.out.println(s);
            }
            if (!boom) s.add(asteroid);
        }
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = s.pop();
        System.out.println(Arrays.toString(res));
        return res;
    }
}

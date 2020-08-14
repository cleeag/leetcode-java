import java.util.Stack;

public class trap42 {
    public static void main(String[] args) {
//        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = new int[] {5, 1, 0, 0, 2, 4};
//        int[] height = new int[]{0, 0, 5, 2, 0, 1, 4, 1, 0};
        int[] height = new int[]{2,1,2};
        trap42 tmp = new trap42();
        System.out.println(tmp.trap(height));
    }

    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (s.size() == 0) {
                s.push(i);
                continue;
            }
            int base;
            while (s.size() > 0 && height[i] > height[s.peek()]) {
                base = height[s.pop()];
                if (s.size() > 0 && base == height[s.peek()]) continue;
                if (s.size() > 0)
                    ans += (Math.min(height[s.peek()], height[i]) - base) * (i - s.peek() - 1);
            }
            System.out.println(s);
            System.out.println(ans);
            s.push(i);
        }
        return ans;
    }
}

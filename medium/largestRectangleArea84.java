import java.awt.*;
import java.util.Map;
import java.util.Stack;

public class largestRectangleArea84 {
    public static void main(String[] args) {
//        int[] h = new int[]{2, 1, 5, 6, 2, 3};
        int[] h = new int[]{2, 1, 1, 1, 1, 1, 1, 0, 2, 1, 2};
//        int[] h = new int[]{1, 1};
        largestRectangleArea84 tmp = new largestRectangleArea84();
        tmp.largestRectangleArea(h);
    }
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) newHeights[i + 1] = heights[i];
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            int curTop;
            while (s.size() > 0 && newHeights[i] < newHeights[s.peek()]) {
                curTop = s.pop();
                maxArea = Math.max(maxArea, newHeights[curTop] * (i - 1 - s.peek()));
            }
            s.add(i);
            System.out.println(i);
            System.out.println(s);
            System.out.println(maxArea);
        }
        return maxArea;
    }

    public int largestRectangleAreaUGLY(int[] heights) {

        Stack<Integer> s = new Stack<>();
        s.add(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int curTop;
            while (s.size() > 1 && heights[i] < heights[s.peek()]) {
                curTop = s.pop();
                maxArea = Math.max(maxArea, heights[curTop] * (i - 1 - s.peek()));
            }
            s.add(i);
            System.out.println(i);
            System.out.println(s);
            System.out.println(maxArea);
        }

        int depth = heights.length;
        int curTop;
        while (s.size() > 1) {
            curTop = s.pop();
            maxArea = Math.max(maxArea, heights[curTop] * (depth - 1 - s.peek()));
            System.out.println(s);
            System.out.println(maxArea);
        }
        System.out.println(maxArea);
        return maxArea;
    }


}

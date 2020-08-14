import java.util.Arrays;

public class isNStraightHand846 {
    public static void main(String[] args) {
        int []hand = new int[] {1,2,3,6,2,3,4,7,8};
        int W = 3;
        isNStraightHand846 tmp = new isNStraightHand846();
        tmp.isNStraightHand(hand, W);
    }
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Arrays.sort(hand);
        int[][] tracker = new int[2][hand.length / W];
        for (int num : hand) {
            boolean haveSpot = false;
            for (int i = 0; i < tracker[0].length; i++) {
                if (tracker[1][i] == 0 || tracker[0][i] == num - 1 && tracker[1][i] < W) {
                    tracker[0][i] = num;
                    tracker[1][i]++;
                    haveSpot = true;
                    break;
                }
            }
            if (!haveSpot) return false;
            System.out.println(Arrays.deepToString(tracker).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
        }
        return true;
    }
}

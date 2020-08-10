import java.util.LinkedList;
import java.util.Queue;

public class getWinner1535 {
    public static void main(String[] args) {
//        int[] a = new int[] {2,1,3,5,4,6,7};
//        int k = 2;
        int[] a = {1, 9, 8, 2, 3, 7, 6, 4, 5};
        int k = 7;
        getWinner1535 tmp = new getWinner1535();
        tmp.getWinner(a, k);
    }

    public int getWinner(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int maxVal = Integer.MIN_VALUE;
        for (int value : arr) {
            q.add(value);
            maxVal = Math.max(maxVal, value);
        }
        if (k > arr.length) return maxVal;

        int rounds = 0;
        int king = q.poll();
        while (rounds < k) {
            int contender = q.poll();
            if (king > contender) {
                q.add(contender);
                rounds++;
            } else {
                q.add(king);
                king = contender;
                rounds = 1;
            }
            System.out.println(q);
            System.out.println(king);
        }
        return king;
    }
}

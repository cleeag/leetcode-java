import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class longestDiverseString1405 {
    public static void main(String[] args) {
//        int a = 1, b = 1, c = 7;
//        int a = 2, b = 2, c = 1;
//        int a = 7, b = 1, c = 0;
//        int a = 7, b = 0, c = 0;
//        int a = 0, b = 8, c = 11;
        int a = 2, b = 4, c = 1;
        longestDiverseString1405 tmp = new longestDiverseString1405();
        tmp.longestDiverseString(a, b, c);
    }

    public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[]{a, b, c};
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparingInt(o -> -count[o]));
        for (int i = 0; i < 3; i++) {
            if (count[i] > 0) p.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (p.size() > 1) {
            int char1 = p.poll();
            int char2 = p.poll();
            int rep1 = Math.min(2, count[char1]);
            sb.append(String.valueOf((char) ('a' + char1)).repeat(rep1));
            count[char1] -= rep1;
            int rep2;
            if (count[char2] > count[char1]) rep2 = Math.min(2, count[char2]);
            else rep2 = 1;
            sb.append(String.valueOf((char) ('a' + char2)).repeat(rep2));
            count[char2] -= rep2;
            if (count[char1] > 0) p.offer(char1);
            if (count[char2] > 0) p.offer(char2);

            System.out.println(sb);
            System.out.println(Arrays.toString(count));
            System.out.println(p);
        }

        if (p.size() > 0) {
            if (sb.charAt(sb.length() - 1) != (char) ('a' + p.peek()))
                sb.append(String.valueOf((char) ('a' + p.peek())).repeat(Math.min(2, count[p.peek()])));
        }
        System.out.println(sb);
        return sb.toString();
    }
}

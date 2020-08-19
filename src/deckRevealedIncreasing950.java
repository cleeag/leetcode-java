import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class deckRevealedIncreasing950 {
    public static void main(String[] args) {
        int[] d = new int[]{17,13,11,2,3,5,7};
        deckRevealedIncreasing950 tmp = new deckRevealedIncreasing950();
        tmp.deckRevealedIncreasing(d);
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length <= 1) return deck;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        q.add(deck[deck.length-1]);
        for (int i = deck.length-2; i >=0; i--) {
            q.add(q.poll());
            q.add(deck[i]);
            System.out.println(q);
        }
        int[] ans = new int[q.size()];
        while (q.size() > 0) ans[q.size()-1] = q.poll();
        return ans;
    }
}

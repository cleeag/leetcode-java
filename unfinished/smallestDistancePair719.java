import java.util.*;

class tup {
    int i;
    int j;

    tup(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class smallestDistancePair719 {
    public static void main(String[] args) {
//        int[] n = new int[]{1, 3, 1, 3, 4, 1};
//        int k = 7;
        int[] n = new int[]{1, 3, 1};
        int k = 1;
        smallestDistancePair719 tmp = new smallestDistancePair719();
        tmp.smallestDistancePair(n, k);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer, Integer> uniqueCount = new HashMap<>();
        for (int num : nums)
            uniqueCount.put(num, uniqueCount.getOrDefault(num, 0) + 1);
        int[] uniqueArray = new int[uniqueCount.size()];
        int i = 0;
        for (Integer integer : uniqueCount.keySet()) uniqueArray[i++] = integer;
        Arrays.sort(uniqueArray);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int j = 0; j < uniqueArray.length; j++) {
            if (uniqueCount.get(uniqueArray[j]) > 1)
                pq.offer(new int[]{0, j, j});
            else if (j < uniqueArray.length - 1)
                pq.offer(new int[]{uniqueArray[j + 1] - uniqueArray[j], j, j + 1});
        }
        int[] tmp;
        int ans = 0;
        while (k > 0 && pq.size() > 0) {
             tmp = pq.poll();
             ans = tmp[0];
            if (tmp[1] == tmp[2]) {
                int counts = uniqueCount.get(uniqueArray[tmp[1]]);
                k -= counts * (counts - 1) / 2;
            } else {
                int counts1 = uniqueCount.get(uniqueArray[tmp[1]]);
                int counts2 = uniqueCount.get(uniqueArray[tmp[2]]);
                k -= counts1 * counts2;
            }
            tmp[2]++;
            if (tmp[2] < uniqueArray.length){
                tmp[0] = uniqueArray[tmp[2]] - uniqueArray[tmp[1]];
                pq.offer(tmp);
            }
            System.out.println(Arrays.toString(tmp));
            System.out.println(k);
        }
        System.out.println(ans);
        return ans;
    }

    public int smallestDistancePairTLE(int[] nums, int k) {
        Map<Integer, Integer> uniqueCount = new HashMap<>();
        for (int num : nums) uniqueCount.put(num, uniqueCount.getOrDefault(num, 0) + 1);

        int[] uniqueArray = new int[uniqueCount.size()];
        int[] pointers = new int[uniqueCount.size()];
        for (int i = 0; i < pointers.length; i++) pointers[i] = i;

        int i = 0;
        for (Integer integer : uniqueCount.keySet()) uniqueArray[i++] = integer;
        Arrays.sort(uniqueArray);
        int minima = Integer.MAX_VALUE;
        while (k > 0) {
            minima = Integer.MAX_VALUE;
            for (int j = 0; j < uniqueArray.length; j++) {
                if (pointers[j] == j && uniqueCount.get(uniqueArray[j]) > 1) {
                    int tmp = uniqueCount.get(uniqueArray[pointers[j]]) - 1;
                    minima = 0;
                    k -= (1 + tmp) * tmp / 2;
                    pointers[j]++;
                    break;
                } else {
                    if (pointers[j] == j) {
                        pointers[j]++;
                    }
                    if (pointers[j] < uniqueArray.length)
                        minima = Math.min(minima, uniqueArray[pointers[j]] - uniqueArray[j]);
                }
            }
            if (minima > 0) {
                for (int j = 0; j < uniqueArray.length; j++) {
                    if (pointers[j] < uniqueArray.length
                            && minima == uniqueArray[pointers[j]] - uniqueArray[j]) {
                        k -= uniqueCount.get(uniqueArray[j]) * uniqueCount.get(uniqueArray[pointers[j]]);
                        pointers[j]++;
                        break;
                    }
                }
            }
            System.out.println(k);
            System.out.println(minima);
            System.out.println(Arrays.toString(pointers));
        }
        System.out.println(uniqueCount);
        System.out.println(Arrays.toString(uniqueArray));
        System.out.println(minima);
        return minima;
    }
}


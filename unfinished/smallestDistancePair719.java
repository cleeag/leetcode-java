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
        int[] n = new int[]{1, 3, 1, 3, 4, 1};
        int k = 7;
//        int[] n = new int[]{1, 3, 1};
//        int k = 1;
        smallestDistancePair719 tmp = new smallestDistancePair719();
        tmp.smallestDistancePair(n, k);
    }
    public int smallestDistancePair(int[] nums, int k) {

        return 0;
    }
    public int smallestDistancePair2ndTLE(int[] nums, int k) {
        Map<Integer, Integer> uniqueCount = new HashMap<>();
        int i = 0;
        for (int num : nums){
            uniqueCount.put(num, uniqueCount.getOrDefault(num, 0) + 1);
        }
        int[] uniqueArray = new int[uniqueCount.size()];
        int[] pointers = new int[uniqueCount.size()];

        for (Integer integer : uniqueCount.keySet()) uniqueArray[i++] = integer;
        Arrays.sort(uniqueArray);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) ->
                uniqueArray[pointers[n1]] - uniqueArray[n1] - (uniqueArray[pointers[n2]] - uniqueArray[n2]));
        int minima = Integer.MAX_VALUE;
        for (int j = 0; j < uniqueArray.length; j++) {
            if (uniqueCount.get(uniqueArray[j]) > 1) {
                int tmp = uniqueCount.get(uniqueArray[j]) - 1;
                minima = 0;
                k -= (1 + tmp) * tmp / 2;
            }
            pointers[j] = j + 1;
            if (pointers[j] < uniqueArray.length) minHeap.add(j);
        }
        while (k > 0) {
            int curIndex = minHeap.poll();
            k -= uniqueCount.get(uniqueArray[curIndex]) * uniqueCount.get(uniqueArray[pointers[curIndex]]);
            minima = uniqueArray[pointers[curIndex]] - uniqueArray[curIndex];
            pointers[curIndex]++;
            if (pointers[curIndex] < uniqueArray.length) minHeap.add(curIndex);
            System.out.println(k);
            System.out.println(Arrays.toString(pointers));
            System.out.println(minima);
        }
        return minima;
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


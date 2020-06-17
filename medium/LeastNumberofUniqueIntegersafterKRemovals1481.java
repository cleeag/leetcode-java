import java.util.*;

public class LeastNumberofUniqueIntegersafterKRemovals1481 {
    public static void main(String[] args) {
        LeastNumberofUniqueIntegersafterKRemovals1481 tmp = new LeastNumberofUniqueIntegersafterKRemovals1481();
        int[] a = new int[] {4,3,1,1,3,3,2};
//        int[] a = new int[] {4,5, 5};
        int k = 3;
        tmp.findLeastNumOfUniqueInts(a, k);
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length) return 0;
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (counts.containsKey(i)) counts.put(i, counts.get(i) + 1);
            else counts.put(i, 1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(counts.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
//        System.out.println(list);
        while (k > 0){
            k -= 1;
            list.set(0, Map.entry(list.get(0).getKey(),list.get(0).getValue() -1));
            if (list.get(0).getValue() == 0) list.remove(0);
            System.out.println(list);
        }
        return list.size();
    }
}

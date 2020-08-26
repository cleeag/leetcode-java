import java.util.*;

public class findLatestStep1562 {
    public static void main(String[] args) {
//        int[] arr = {3, 5, 1, 2, 4};
//        int m = 2;
//        int[] arr = {1};
//        int m = 1;
        int[] arr = {1,2};
        int m = 1;
        findLatestStep1562 tmp = new findLatestStep1562();
        tmp.findLatestStep(arr, m);
    }

    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) return m;
        Map<Integer, Integer> floor = new HashMap<>();
        Map<Integer, Integer> roof = new HashMap<>();
        int latestStep = -1;
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i];
            if (!roof.containsKey(pos) && !floor.containsKey(pos + 1)) {
                floor.put(pos, pos + 1);
                roof.put(pos + 1, pos);
            } else {
                int theFloor = pos;
                if (roof.containsKey(pos)) {
                    int itsFloor = roof.get(pos);
                    if (pos - itsFloor == m) latestStep = i;
                    theFloor = itsFloor;
                    floor.put(itsFloor, pos + 1);
                    roof.remove(pos);
                    roof.put(pos + 1, itsFloor);
                }
                if (floor.containsKey(pos + 1)) {
                    int itsRoof = floor.get(pos + 1);
                    if (itsRoof - (pos + 1) == m) latestStep = i;
                    roof.remove(pos + 1);
                    roof.put(itsRoof, theFloor);
                    floor.remove(pos + 1);
                    floor.put(theFloor, itsRoof);
                }
            }
        }
        return latestStep;
    }
}

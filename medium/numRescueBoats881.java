import java.util.Arrays;

public class numRescueBoats881 {
    public static void main(String[] args) {
        int[] p = new int[]{3, 2, 2, 1};
        int l = 3;
//        int[] p = new int[]{2, 2};
//        int l = 6;
//        int[] p = new int[]{3, 5, 3, 4};
//        int l = 5;
//        int[] p = new int[]{3,2,3,2,2};
//        int l = 6;

        numRescueBoats881 tmp = new numRescueBoats881();
        System.out.println(tmp.numRescueBoats(p, l));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = 0;
        for (int i = 0; i < people.length + 1; i++) {
            right = i;
            left = i - 1;
            if (i < people.length && people[i] * 2 > limit) break;
        }
        int fatLeft = 0;
        int boats = 0;
        while (left >= 0 && right < people.length) {
            if (people[left] + people[right] > limit) {
                fatLeft++;
                left--;
            } else {
                boats++;
                left--;
                right++;
            }
            System.out.println(boats + " " + left + " " + right + " " + fatLeft);
        }
        fatLeft += left + 1;
        fatLeft = fatLeft % 2 == 0 ? fatLeft / 2 : fatLeft / 2 + 1;
        return boats + people.length - right + fatLeft;
    }
}

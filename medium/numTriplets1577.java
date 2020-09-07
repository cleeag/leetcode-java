import java.util.Arrays;

public class numTriplets1577 {
    public static void main(String[] args) {
//        int[] n1 = new int[]{3, 1, 2, 2};
//        int[] n2 = new int[]{1, 3, 4, 4};
//        int[] n1 = new int[]{4, 1, 4, 1, 12};
//        int[] n2 = new int[]{3, 2, 5, 4};

        int[] n1 = new int[]{43024, 99908};
        int[] n2 = new int[]{1864};
        System.out.println(43024 * 99908);
        System.out.println(1864 * 1864);
        System.out.println(Integer.MAX_VALUE);
        numTriplets1577 tmp = new numTriplets1577();
        tmp.numTriplets(n1, n2);

    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] count1 = new int[100001];
        int[] count2 = new int[100001];
        for (int i = 0; i < nums1.length; i++) count1[nums1[i]]++;
        for (int i = 0; i < nums2.length; i++) count2[nums2[i]]++;

        int ans = 0;
        for (int t = 0; t < 2; t++) {
            int[] a, b;
            int[] countB;
            if (t == 0) {
                a = nums1;
                b = nums2;
                countB = count2;
            } else {
                a = nums2;
                b = nums1;
                countB = count1;
            }
            for (int i = 0; i < a.length; i++) {
                int j = 0, k = b.length - 1;
                long target = ((long) a[i]) * a[i];
                while (j <= k) {
                    long prod = ((long) b[j]) * b[k];
                    if (target == prod) {
                        System.out.println(prod);
                        if (b[j] == b[k]) ans += (countB[b[k]] - 1) * countB[b[k]] / 2;
                        else ans += countB[b[j]] * countB[b[k]];
                        j++;
                        while (j < b.length && b[j] == b[j - 1]) j++;
                    } else if (prod > target) {
                        k--;
                        while (k >= 0 && b[k] == b[k + 1]) k--;
                    } else {
                        j++;
                        while (j < b.length && b[j] == b[j - 1]) j++;
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int numTripletsdumb(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = 0, k = nums2.length - 1;
            int target = nums1[i] * nums1[i];
            while (j < k) {
                int prod = nums2[j] * nums2[k];
                if (target == prod) {
                    System.out.println(i + " " + j + " " + k);
                    if (nums2[j] == nums2[k]) {
                        ans += k - j;
                    } else ans++;
                    if (k > 0 && nums2[k] == nums2[k - 1]) k--;
                    else j++;
                } else if (prod > target) k--;
                else j++;
            }
        }
        System.out.println("yo");
        for (int i = 0; i < nums2.length; i++) {
            int j = 0, k = nums1.length - 1;
            int target = nums2[i] * nums2[i];
            while (j < k) {
                int prod = nums1[j] * nums1[k];
                if (target == prod) {
                    System.out.println(i + " " + j + " " + k);
                    if (nums1[j] == nums1[k]) {
                        ans += k - j;
                    } else ans++;
                    if (k > 0 && nums1[k] == nums1[k - 1]) k--;
                    else j++;
                } else if (prod > target) k--;
                else j++;
            }
        }
        return ans;
    }
}

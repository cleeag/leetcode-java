public class mctFromLeafValues1130 {
    public int mctFromLeafValues(int[] arr) {
        int power = 1;
        while (arr.length > (int)Math.pow(2, power)) power++;
        int surplus = arr.length - (int)Math.pow(2, power -1);
        return 0;
    }
}

import java.util.*;

class Solution {

    public int[] sortByBits(int[] arr) {

        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if (bitA == bitB) {
                return a - b;
            }
            return bitA - bitB;
        });

        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }
}

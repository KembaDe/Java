import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers to use: [1, 2, 3, ..., n]
        // 2. Precompute factorials: 0! = 1, 1! = 1, 2! = 2, 3! = 6...
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // Adjust k to be 0-indexed for easier math
        k--;

        // 3. Find the digit for each position
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index); // Remove used digit
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}

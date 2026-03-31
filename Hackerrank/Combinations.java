import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the combination is the required size
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: i <= n - (k - current.size()) + 1
        // This avoids starting loops where there aren't enough numbers left to finish the combo
        for (int i = start; i <= n; i++) {
            current.add(i);             // Choose the number
            backtrack(i + 1, n, k, current, result); // Explore further
            current.remove(current.size() - 1); // Backtrack (remove the number)
        }
    }
}

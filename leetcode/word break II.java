import java.util.*;

class Solution {
    // Memoization map to store results for substrings
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a Set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // If we've already computed the result for this substring, return it
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();
        
        // Base case: if the entire string is a valid word, add it
        if (wordSet.contains(s)) {
            res.add(s);
        }

        // Try splitting the string at every possible index
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            
            if (wordSet.contains(left)) {
                String right = s.substring(i);
                // Recursively find all valid sentences for the right part
                List<String> rightSubResults = backtrack(right, wordSet);
                
                // Combine the current left word with all results from the right part
                for (String sub : rightSubResults) {
                    res.add(left + " " + sub);
                }
            }
        }

        // Save the result in the map before returning
        memo.put(s, res);
        return res;
    }
}

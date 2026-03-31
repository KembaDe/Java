import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // Optimization: Max length for 4 segments of 3 digits is 12
        if (s.length() < 4 || s.length() > 12) return result;
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // Base case: Found 4 segments
        if (current.size() == 4) {
            // If we also used all characters in the string, it's valid
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            
            String segment = s.substring(start, start + len);
            
            // Check for leading zero (e.g., "01", "001")
            if (segment.length() > 1 && segment.startsWith("0")) continue;
            
            // Check if value is within 0-255
            if (Integer.parseInt(segment) > 255) continue;
            
            current.add(segment);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

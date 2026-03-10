import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        
        Set<String> set = new HashSet<>();
        long area = 0;

        for (int[] rect : rectangles) {
            // Update bounding box coordinates
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            // Add to total area
            area += (long)(rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            // Track corners
            String[] corners = {
                rect[0] + " " + rect[1], // bottom-left
                rect[0] + " " + rect[3], // top-left
                rect[2] + " " + rect[1], // bottom-right
                rect[2] + " " + rect[3]  // top-right
            };

            for (String s : corners) {
                // If corner exists, remove it (even count). If not, add it (odd count).
                if (!set.add(s)) set.remove(s);
            }
        }

        // Check 1: The four corners of the bounding box must be the only ones left
        if (set.size() != 4 || 
            !set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || 
            !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)) {
            return false;
        }

        // Check 2: Total area must match the bounding box area
        return area == (long)(x2 - x1) * (y2 - y1);
    }
}

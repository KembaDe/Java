import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxPointsOnALine = 1;

        for (int i = 0; i < n; i++) {
            // Map stores slope as a Double -> Count of points with that slope
            Map<Double, Integer> slopeCounts = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                double deltaX = points[j][0] - points[i][0];
                double deltaY = points[j][1] - points[i][1];
                
                double slope;
                if (deltaX == 0) {
                    slope = Double.POSITIVE_INFINITY; // Vertical line
                } else if (deltaY == 0) {
                    slope = 0.0; // Horizontal line
                } else {
                    // Use atan2 or precise division to represent the slope
                    slope = deltaY / deltaX;
                }

                slopeCounts.put(slope, slopeCounts.getOrDefault(slope, 1) + 1);
                maxPointsOnALine = Math.max(maxPointsOnALine, slopeCounts.get(slope));
            }
        }

        return maxPointsOnALine;
    }
}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. Sort by the start time of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            // 2. Check for overlap
            if (currentEnd >= nextStart) {
                // Merge: update the end of the current interval to the max end found
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: move to the next interval and add it to the list
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        // 3. Convert List back to 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Base case: if there's 1 or 0 intervals, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        // Initialize the first interval as our current working interval
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Step 2: Check if intervals overlap
            if (nextStart <= currentEnd) {
                // Overlap found: merge them by updating the end time of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: move to the next interval and add it to our list
                currentInterval = intervals[i];
                mergedList.add(currentInterval);
            }
        }

        // Convert the list back to a 2D array and return
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}

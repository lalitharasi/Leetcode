class Solution {
    public int jump(int[] nums) {
        // If the array has only 1 element, you are already at the end
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Traverse the array up to the second-to-last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Continuously update the farthest index reachable from any position so far
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++;             // We must make a jump
                currentEnd = farthest; // Move our window boundary to the farthest reachable point

                // Early exit: if we can already reach or pass the last index, stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}

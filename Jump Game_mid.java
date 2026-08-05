class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        // Traverse backward from the second-to-last element down to 0
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i; // Move the goal closer to the start
            }
        }

        // If the goal reached the starting index, a valid path exists
        return goal == 0;
    }
}

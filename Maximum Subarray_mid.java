class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize running sum and absolute max sum with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to combine with the previous subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Track the highest sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

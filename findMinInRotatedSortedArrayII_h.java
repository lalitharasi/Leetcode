class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // Minimum is in the right half (excluding mid)
                left = mid + 1;
            } else {
                // Ambiguity: nums[mid] == nums[right]
                // We can't discard half, but we know nums[right] is redundant
                right--;
            }
        }

        return nums[left];
    }
}

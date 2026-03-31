class Solution {
    public int removeElement(int[] nums, int val) {
        // 'k' tracks the position where the next valid element should go
        int k = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the one we want to remove
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        // k is the count of elements not equal to val
        return k;
    }
}
//easy
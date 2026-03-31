class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        // 'i' is the pointer for the last unique element found
        int i = 0;
        
        // 'j' scans through the array looking for new unique elements
        for (int j = 1; j < nums.length; j++) {
            // If we find a value different from the last unique one
            if (nums[j] != nums[i]) {
                i++;           // Move the unique pointer forward
                nums[i] = nums[j]; // Update the next unique position with the new value
            }
        }
        
        // The number of unique elements is the index + 1
        return i + 1;
    }
}
//mid
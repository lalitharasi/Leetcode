function twoSum(nums, target) {
    const map = {};  // To store number and its index
    
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        
        // Check if complement exists in map
        if (map.hasOwnProperty(complement)) {
            return [map[complement], i];
        }
        
        // Store current number with its index
        map[nums[i]] = i;
    }
}
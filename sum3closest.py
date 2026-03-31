class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        mid
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        closest_sum = float('inf')
        
        for i in range(len(nums) - 2):
            # Optimization: skip duplicates for the first element
            if i > 0 and nums[i] == nums[i-1]:
                continue
                
            l, r = i + 1, len(nums) - 1
            while l < r:
                current_sum = nums[i] + nums[l] + nums[r]
                
                # If we find the exact target, return immediately
                if current_sum == target:
                    return current_sum
                
                # Update closest_sum if the current_sum is nearer to the target
                if abs(current_sum - target) < abs(closest_sum - target):
                    closest_sum = current_sum
                
                if current_sum < target:
                    l += 1
                else:
                    r -= 1
                    
        return closest_sum

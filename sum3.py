class Solution(object):
    def threeSum(self, nums):
        """
        mid
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()  # Sort to use two-pointer approach and skip duplicates easily
        
        for i in range(len(nums)):
            # If the current smallest number is > 0, no triplet can sum to 0
            if nums[i] > 0:
                break
            
            # Skip the same element to avoid duplicate triplets
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            l, r = i + 1, len(nums) - 1
            while l < r:
                three_sum = nums[i] + nums[l] + nums[r]
                
                if three_sum > 0:
                    r -= 1
                elif three_sum < 0:
                    l += 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    # Skip duplicate values for the second element
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                        
        return res

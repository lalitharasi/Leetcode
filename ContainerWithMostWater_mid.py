class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_water = 0
        l, r = 0, len(height) - 1
        
        while l < r:
            # Calculate area with current pointers
            current_width = r - l
            current_height = min(height[l], height[r])
            current_water = current_width * current_height
            
            # Update global maximum
            max_water = max(max_water, current_water)
            
            # Move the pointer of the shorter line
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
                
        return max_water

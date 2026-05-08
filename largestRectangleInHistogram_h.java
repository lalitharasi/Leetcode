import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use a dummy height of 0 at the end to flush out the remaining bars in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // If current bar is shorter than the bar at stack top, calculate area for the top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // If stack is empty, width is 'i'. Otherwise, width is 'i - left_boundary - 1'
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

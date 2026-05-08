class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                // Update height: if '1' add to previous, else reset to 0
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }
            // Find max area for the current histogram row
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }
        
        return maxArea;
    }

    private int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as a sentinel value to flush the stack at the end
            int currentHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

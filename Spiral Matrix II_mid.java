public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        int counter = 1;
        
        while (counter <= n * n) {
            // 1. Move Left to Right along the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = counter++;
            }
            top++;
            
            // 2. Move Top to Bottom along the right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = counter++;
            }
            right--;
            
            // 3. Move Right to Left along the bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = counter++;
            }
            bottom--;
            
            // 4. Move Bottom to Top along the left column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = counter++;
            }
            left++;
        }
        
        return matrix;
    }
}

import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPoints = 1;
        
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();
            
            for (int j = i + 1; j < n; j++) {
                double slope = calculateSlope(points[i], points[j]);
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
            }
            
            for (int count : slopeMap.values()) {
                maxPoints = Math.max(maxPoints, count + 1);
            }
        }
        
        return maxPoints;
    }
    
    private double calculateSlope(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        
        if (dx == 0) return Double.POSITIVE_INFINITY; // Vertical line
        if (dy == 0) return 0.0; // Horizontal line (prevents -0.0 issues)
        
        return (double) dy / dx;
    }
}

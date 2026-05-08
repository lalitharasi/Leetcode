class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // dp[i][j] is true if s[i...j] is a palindrome
        boolean[][] isPal = new boolean[n][n];
        // minCuts[i] is the minimum cuts for substring s[0...i]
        int[] minCuts = new int[n];

        for (int i = 0; i < n; i++) {
            // Initializing with maximum possible cuts (each char a cut)
            int min = i; 
            for (int j = 0; j <= i; j++) {
                // Check if s[j...i] is a palindrome
                // Characters must match, and the inner part must be a palindrome or length < 2
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    // If the whole prefix is a palindrome, cuts = 0
                    // Otherwise, it's min(current, cuts for previous part + 1)
                    min = (j == 0) ? 0 : Math.min(min, minCuts[j - 1] + 1);
                }
            }
            minCuts[i] = min;
        }

        return minCuts[n - 1];
    }
}

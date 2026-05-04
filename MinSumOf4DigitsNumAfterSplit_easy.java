class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        
        // Extract all 4 digits
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        
        // Sort digits in ascending order
        java.util.Arrays.sort(digits);
        
        // Form two numbers:
        // new1 tens digit = digits[0], ones digit = digits[2]
        // new2 tens digit = digits[1], ones digit = digits[3]
        int new1 = digits[0] * 10 + digits[2];
        int new2 = digits[1] * 10 + digits[3];
        
        return new1 + new2;
    }
}

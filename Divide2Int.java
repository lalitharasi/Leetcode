class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (which overflows to -2^31)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during absolute value conversion
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        // Exponential search / Bit shifting
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int numShifts = 1;
            
            // Shift divisor left (double it) as long as it's smaller than dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                numShifts <<= 1;
            }

            // Subtract the largest found multiple and add count to result
            absDividend -= tempDivisor;
            result += numShifts;
        }

        return isNegative ? -result : result;
    }
}
//mid
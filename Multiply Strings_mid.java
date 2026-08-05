class Solution {
    public String multiply(String num1, String num2) {
        // Edge case check for zero multiplication
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // The product of an m-digit and n-digit number is at most m + n digits long
        int[] pos = new int[m + n];
        
        // Loop backwards through both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Determine destination indices in the results array
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add current multiplication result to any existing value at position p2
                int sum = mul + pos[p2];
                
                // Update position p2 with the remainder and position p1 with the carry
                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }
        
        // Build final string result, ignoring any leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}

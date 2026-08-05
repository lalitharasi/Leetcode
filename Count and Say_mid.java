class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n <= 0) return "";
        
        String result = "1";
        
        // Iteratively generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = result.length();
            
            int count = 1;
            // Traverse the string to perform Run-Length Encoding
            for (int j = 1; j < len; j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++; // Increment count if characters match
                } else {
                    // Append count followed by the actual character
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1; // Reset count for the next character group
                }
            }
            // Append the final group of characters
            sb.append(count).append(result.charAt(len - 1));
            
            // Move to the next string state
            result = sb.toString();
        }
        
        return result;
    }
}

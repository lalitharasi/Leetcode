class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        // If needle is longer than haystack, it's impossible to find a match
        if (nLen > hLen) return -1;
        
        // Loop through haystack until there isn't enough space left for the needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring starting at i matches the needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
//easy  
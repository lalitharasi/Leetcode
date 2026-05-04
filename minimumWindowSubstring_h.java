import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Map to store character requirements from t
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = t.length(); // Number of characters still needed

        while (end < s.length()) {
            char c1 = s.charAt(end);
            // If the character at 'end' is needed, decrease counter
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;

            // When all characters are found, try to shrink from the left
            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                map[c2]++;
                // If the character removed was a required one, increase counter
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

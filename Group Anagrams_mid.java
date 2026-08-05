import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case fallback
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Count frequencies of each character (a-z)
            int[] count = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 'a']++;
            }

            // Convert character frequencies into a unique string key
            // Format example: #1#0#1#0... up to 26 elements
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append('#').append(val);
            }
            String key = sb.toString();

            // Initialize list if key does not exist yet
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Group the original string under its character frequency fingerprint key
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

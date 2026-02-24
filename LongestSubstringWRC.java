import java.util.HashMap;

class LongestSubstringWRC {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If character exists and is inside current window
            if (map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;
            }

            map.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
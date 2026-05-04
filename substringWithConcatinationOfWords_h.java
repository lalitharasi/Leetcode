import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int wordLen = words[0].length(); 
        int wordCount = words.length;    
        int totalLen = wordLen * wordCount;
        
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Iterate through all possible starting offsets (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i;
            int count = 0;

            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If word frequency exceeds the target, slide 'left' forward
                    while (seen.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words matched, add start index to result
                    if (count == wordCount) {
                        res.add(left);
                    }
                } else {
                    // Invalid word found: reset window
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }
}

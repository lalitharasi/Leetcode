import java.util.*;

class Solution {
    // Map to store results of previously processed suffixes
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // If we've seen this string before, return the cached result
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<>();
        
        // Base case: empty string returns a list containing an empty string
        // to act as a trigger for sentence building
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        // Try every possible prefix
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            
            if (wordSet.contains(prefix)) {
                // Get all valid sentences for the remaining suffix
                List<String> subSentences = backtrack(s.substring(i), wordSet);
                
                for (String sub : subSentences) {
                    // Combine prefix with the suffix results
                    String space = sub.isEmpty() ? "" : " ";
                    result.add(prefix + space + sub);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}

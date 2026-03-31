import java.util.ArrayList;
import java.util.List;
//mid

class Solution {
    // Mapping of digits to corresponding phone letters
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result; // Base case: return empty list for empty input
        }
        
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Base case: if current combination length equals input digits length, we found a result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit (e.g., '2' -> "abc")
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);              // Choose: Add a letter
            backtrack(result, digits, current, index + 1); // Explore: Move to next digit
            current.deleteCharAt(current.length() - 1); // Backtrack: Remove the letter for next iteration
        }
    }
}

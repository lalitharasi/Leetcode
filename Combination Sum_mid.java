import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from the 0-th index with an empty current combination
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        // Base case: if remainder drops below 0, this path is invalid
        if (remain < 0) {
            return;
        }
        
        // Base case: if remainder hits exactly 0, a valid combination is found
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore further branches
        for (int i = start; i < candidates.length; i++) {
            // Choose the current candidate
            current.add(candidates[i]);
            
            // Recurse: notice we pass 'i' instead of 'i + 1' 
            // because we can reuse the exact same element multiple times
            backtrack(candidates, remain - candidates[i], i, current, result);
            
            // Unchoose the element (backtrack) to explore alternative routes
            current.remove(current.size() - 1);
        }
    }
}

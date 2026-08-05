import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting is mandatory to group duplicates together and handle skipping
        Arrays.sort(candidates);
        
        // Start the backtracking simulation
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        // Base Case: successfully hit the target sum
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if the element is greater than the remaining target, 
            // all subsequent elements will also be too large due to sorting.
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate combinations: 
            // If the element is the same as the previous one AND it is not 
            // the first element chosen for this specific slot position.
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose the candidate
            current.add(candidates[i]);

            // Move forward to the next index (i + 1) because elements cannot be reused
            backtrack(candidates, remain - candidates[i], i + 1, current, result);

            // Backtrack (unchoose the candidate)
            current.remove(current.size() - 1);
        }
    }
}

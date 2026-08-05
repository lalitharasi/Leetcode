import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to ensure duplicate values sit adjacent to each other
        Arrays.sort(nums);
        
        // Track whether an element at index i is currently in use
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // Base case: a complete unique permutation has been assembled
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) {
                continue;
            }

            // Duplicate Pruning Condition:
            // Skip the current element if it is identical to the previous element
            // AND the previous element has NOT been used in this recursive frame.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose the element
            used[i] = true;
            current.add(nums[i]);

            // Recurse to find the remaining numbers
            backtrack(nums, used, current, result);

            // Backtrack: undo our choices for the next branch evaluation
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

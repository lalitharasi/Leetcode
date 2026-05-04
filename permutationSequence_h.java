import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Precompute factorials and create a list of numbers [1, 2, ..., n]
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // 2. Adjust k to 0-based index
        k--;

        // 3. Iteratively pick the correct number
        for (int i = 1; i <= n; i++) {
            int groupSize = factorial[n - i];
            int index = k / groupSize;
            
            sb.append(numbers.get(index));
            numbers.remove(index); // Remove used number
            
            k %= groupSize;
        }

        return sb.toString();
    }
}

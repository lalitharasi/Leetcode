class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromNode(root);
        return maxSum;
    }

    private int gainFromNode(TreeNode node) {
        if (node == null) return 0;

        // Recursively get the max gain from subtrees
        // Ignore negative gains by using Math.max(..., 0)
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // Price of a new path with the current node as the highest point (peak)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain the parent can get from this node
        return node.val + Math.max(leftGain, rightGain);
    }
}

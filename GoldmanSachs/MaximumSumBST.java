package GoldmanSachs;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class MaximumSumBST {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;
        findMaxSumBst(root);
        return maxSum;
    }

    public NodeWrapper findMaxSumBst(TreeNode node) {
        if (node == null)
            return new NodeWrapper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeWrapper left = findMaxSumBst(node.left);
        NodeWrapper right = findMaxSumBst(node.right);
        if (left == null || right == null || node.val <= left.upper || node.val >= right.lower) {
            return null;
        }
        maxSum = Math.max(maxSum, node.val + left.sum + right.sum);
        int lower = Math.min(node.val, left.lower);
        int upper = Math.max(node.val, right.upper);

        return new NodeWrapper(lower, upper, left.sum + right.sum + node.val);
    }

    class NodeWrapper {
        int lower;
        int upper;
        int sum;

        public NodeWrapper(int lower, int upper, int sum) {
            this.lower = lower;
            this.upper = upper;
            this.sum = sum;
        }
    }
}

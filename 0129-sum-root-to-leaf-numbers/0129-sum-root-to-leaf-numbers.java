/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return LeafCount(root, 0);
    }

    public int LeafCount(TreeNode root, int concat) {
        if (root == null) return 0;
        concat = concat * 10 + root.val;
        if (root.left == null && root.right == null) return concat;
        int left = LeafCount(root.left, concat);
        int right = LeafCount(root.right, concat);

        return left + right;
    }
}
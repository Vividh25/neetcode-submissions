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
    public int diameterOfBinaryTree(TreeNode root) {
        // int leftHeight = 0, rightHeight = 0;
        int[] res = new int[1];
        recur(root, res);

        return res[0];
    }

    public int recur(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = recur(root.left, res);
        int right = recur(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
        // int rightHeight = recur(root.right, diameter+1);
    }
}

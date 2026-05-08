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
    Map<TreeNode, Integer> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;

        if (dp.containsKey(root)) return dp.get(root);

        int pick = root.val;

        if (root.left != null) {
            pick += recur(root.left.left);
            pick += recur(root.left.right);
        }

        if (root.right != null) {
            pick += recur(root.right.left);
            pick += recur(root.right.right);
        }

        int skip = recur(root.left) + recur(root.right);

        dp.put(root, Math.max(pick, skip));

        return dp.get(root);
    }
}
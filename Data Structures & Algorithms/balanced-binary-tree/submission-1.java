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
    public boolean isBalanced(TreeNode root) {
        // int[] res = new int[2];
        if (root == null) return true;
        int left = height(root.left, 0);
        int right = height(root.right, 0);

        System.out.println(left + " " + right);
        return (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right));


    }

    public int height(TreeNode root, int h) {
        if (root == null) return h;

        return Math.max(height(root.left, h+1), height(root.right, h+1));
    }
}

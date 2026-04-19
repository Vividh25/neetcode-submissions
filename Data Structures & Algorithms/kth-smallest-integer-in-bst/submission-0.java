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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        for (int i : vals) System.out.println(i);
        return vals.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;

        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}

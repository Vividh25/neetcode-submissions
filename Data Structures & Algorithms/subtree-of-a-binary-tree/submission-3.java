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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode sub = root;
        boolean isSub = false;
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.val == subRoot.val) {
                isSub = recur(node, subRoot);
                if (isSub == true) break;
            }
            if (node.left != null) st.add(node.left);
            if (node.right != null) st.add(node.right);
        }

        return isSub;
    }

    public boolean recur(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return recur(root.left, subRoot.left) && recur(root.right, subRoot.right);
    }
}

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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();

        dfs(root, inorder);

        TreeNode node1 = null, node2 = null;
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                node2 = inorder.get(i + 1);
                if (node1 == null) node1 = inorder.get(i);
                else break;
            }
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void dfs(TreeNode root, List<TreeNode> inorder) {
        if (root == null) return;

        dfs(root.left, inorder);
        inorder.add(root);
        dfs(root.right, inorder);
    }
}
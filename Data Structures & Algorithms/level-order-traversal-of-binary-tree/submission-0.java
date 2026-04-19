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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    curr.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (curr.size() > 0) ans.add(curr);
        }
        return ans;
    }
}

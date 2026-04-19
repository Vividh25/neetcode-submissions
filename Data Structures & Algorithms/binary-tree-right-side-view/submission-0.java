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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        // ans.add(root.val);
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
                // if (dq.peekLast() != null) System.out.println(dq.peekLast().val);
            }

            if (!curr.isEmpty()) ans.add(curr.get(curr.size() - 1));
        }
        return ans;
    }
}

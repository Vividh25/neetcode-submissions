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
    public int goodNodes(TreeNode root) {
        int count = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, root.val));

        while (!st.isEmpty()) {
            Pair p = st.pop();
            TreeNode node = p.node;
            int maxSoFar = p.max;

            if (node.val >= maxSoFar) count++;
            if (node.left != null) st.push(new Pair(node.left, Math.max(maxSoFar, node.val)));
            if (node.right != null) st.push(new Pair(node.right, Math.max(maxSoFar, node.val)));
        }
        return count;
    }

    class Pair {
        TreeNode node;
        int max;

        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }

    // public int dfs(TreeNode root, int maxSoFar) {
    //     if (root == null) return 0;

    //     int count = root.val >= maxSoFar ? 1 : 0;
    //     maxSoFar = Math.max(maxSoFar, root.val);

    //     count += dfs(root.left, maxSoFar);
    //     count += dfs(root.right, maxSoFar);

    //     return count;
    // }
}

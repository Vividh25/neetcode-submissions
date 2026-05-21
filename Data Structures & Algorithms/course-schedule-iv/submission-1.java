class Solution {
    Map<Integer, List<Integer>> graph;
    Integer[][] dp;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        graph = new HashMap<>();
        dp = new Integer[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());

        for (int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            graph.get(u).add(v);
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            res.add(dfs(query[1], query[0]));
        }
        return res;
    }

    public boolean dfs(int node, int target) {
        if (node == target ) return true;
        if (dp[node][target] != null) return dp[node][target] == 1;

        for (int nbr : graph.get(node)) {
            if (dfs(nbr, target)) {
                dp[node][target] = 1;
                return true;
            }
        }
        dp[node][target] = 0;
        return false;
    }
}
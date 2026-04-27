class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;

        for (int nbr : graph.get(node)) {
            dfs(graph, nbr, visited);
        }
    }
}

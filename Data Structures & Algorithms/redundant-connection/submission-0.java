class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = edges.length;
        
        for (int i = 0; i <= n; i++) graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            boolean[] visited = new boolean[n + 1];
            if (addsCycle(graph, u, -1, visited)) {
                return edge;
            }
        }
        return new int[0];
    }

    public boolean addsCycle(Map<Integer, List<Integer>> graph, int node, int parent, boolean[] visited) {
        if (visited[node]) return true;

        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (nbr == parent) continue;
            if(addsCycle(graph, nbr, node, visited)) return true;
        }
        return false;
    }
}

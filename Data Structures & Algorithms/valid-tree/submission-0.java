class Solution {
    Set<Integer> visited;
    Set<Integer> visiting;
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        visited = new HashSet<>();
        visiting = new HashSet<>();

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if(hasCycle(graph, 0, -1)) return false;

        return visited.size() == n;
    }

    public boolean hasCycle(Map<Integer, List<Integer>> graph, int node, int parent) {
        if (visited.contains(node)) {
            return true;
        }

        visited.add(node);

        for (int nbr : graph.get(node)) {
            if (nbr == parent) continue;
            if (hasCycle(graph, nbr, node)) return true;
        }

        return false;
    }
}

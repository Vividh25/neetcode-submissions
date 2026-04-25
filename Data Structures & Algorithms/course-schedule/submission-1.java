class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) graph.get(p[0]).add(p[1]);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited)) return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) {
            return false;
        }

        if (graph.get(node).isEmpty()) return true;

        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (!dfs(graph, nbr, visited)) return false;
        }
        visited[node] = false;
        graph.put(node, new ArrayList<>());
        return true;
    }
}

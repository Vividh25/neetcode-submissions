class Solution {
    Set<Integer> visiting;
    Set<Integer> visited;
    boolean hasCycle;
    List<Integer> ls;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] ans = new int[numCourses];
        visiting = new HashSet<>();
        visited = new HashSet<>();
        ls = new ArrayList<>();
        hasCycle = false;

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        //Build graph
        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            graph.get(v).add(u);
        }

        //Perform dfs on every element
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
            if (hasCycle) return new int[]{};
        }

        Collections.reverse(ls);
        
        for (int i = 0; i < numCourses; i++) {
            ans[i] = ls.get(i);
        }

        return ans;
        
    }

    public void dfs(Map<Integer, List<Integer>> graph, int node) {
        if (visiting.contains(node)) {
            hasCycle = true;
            return;
        }

        if (visited.contains(node)) return;

        visiting.add(node);

        for (int nbr : graph.get(node)) {
            dfs(graph, nbr);
            if (hasCycle) return;
        }

        visiting.remove(node);
        visited.add(node);
        ls.add(node);
    }
}

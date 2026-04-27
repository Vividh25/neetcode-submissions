class Solution {
    List<Integer> ls;
    boolean hasCycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        hasCycle = false;
        int[] ans = new int[numCourses];
        ls = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i, visiting);
            if (hasCycle) return new int[]{};
        }

        Collections.reverse(ls);
        System.out.println(ls);

        for (int i = 0; i < numCourses; i++) {
            ans[i] = ls.get(i);
        }
        return ans;

    }

    public void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visiting) {
        if (visiting.contains(node)) {
            hasCycle = true;
            return;
        }

        if (graph.get(node) == null) return;

        visiting.add(node);

        for (int nbr : graph.get(node)) {
            dfs(graph, nbr, visiting);
            if (hasCycle) return;
        }

        visiting.remove(node);
        ls.add(node);

        graph.put(node, null);
    }
}

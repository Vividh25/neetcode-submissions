class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        
        for (int[] p : prerequisites) {
            indegree[p[1]]++;
            graph.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int finish = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.offer(nbr);
            }
        }

        return finish == numCourses;
    }
}

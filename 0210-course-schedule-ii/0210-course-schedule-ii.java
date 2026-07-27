class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int course = edge[0];
            int prerequisite = edge[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] ans = new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++]=node;
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        if (i != V) {
            return new int[0];
        }
        return ans;
    }

}
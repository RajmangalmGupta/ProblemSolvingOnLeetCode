class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int deg[]=findDegreeInUndirectedGraph(roads, n);
        Arrays.sort(deg);
        long sum=0;
        for(int i=1;i<=n;i++){
            sum += (long)i*deg[i-1];
        }
        return sum;
    }
    public int[] findDegreeInUndirectedGraph(int edges[][], int nodes){
        int degree[] = new int[nodes];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }
        return degree;
   }
}
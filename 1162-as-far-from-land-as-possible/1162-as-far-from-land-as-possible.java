class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dist=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j]==1){
                    q.add(new int[]{i, j});
                }else{
                    grid[i][j]=-1;
                }
            }
        }
        int[][] positions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int[] pos : positions){
                int nr = r + pos[0];
                int nc = c + pos[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc]==-1){
                    grid[nr][nc] = grid[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                    if(grid[nr][nc]>dist){
                        dist = grid[nr][nc];
                    }
                }
            }
        }
        return dist-1;
    }
}
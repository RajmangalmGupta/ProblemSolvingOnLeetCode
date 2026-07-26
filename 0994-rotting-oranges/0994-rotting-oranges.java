class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes=0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if (grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir : directions){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];

                    if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes-1:-1;
    }
}
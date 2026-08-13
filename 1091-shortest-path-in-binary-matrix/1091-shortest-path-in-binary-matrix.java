class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;
        int len=1;
        int[][] positions = {{1,1},{-1,-1},{1,0},{0,1},{-1,0},{0,-1},{+1,-1},{-1,+1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node=q.poll();
                if(node[0] == rows-1 && node[1] == cols-1){
                    return len;
                }
                for(int[] pos : positions){
                    int r = node[0] + pos[0];
                    int c = node[1] + pos[1];
                    if (r < 0 || r >= rows || c < 0 || c >= cols){
                        continue;
                    }
                    if(grid[r][c] == 0) {
                        grid[r][c] = 1;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
            
class Solution {
    int rows;
    int cols;
    
    public int dfs(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row >= rows || col < 0 || col >= cols 
           || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }
        visited[row][col] = true;
        return 1+
            + dfs(row+1, col, grid, visited)
            + dfs(row-1, col, grid, visited)
            + dfs(row, col+1, grid, visited)
            + dfs(row, col-1, grid, visited);
    }

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int max = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(dfs(i, j, grid, visited),max);
                }
            }
        }
        return max;
    }
}
class Solution {
    int rows;
    int cols;
    int OriginalColor;
    public void dfs(boolean[][] visited,int row,int col, int newColor, int[][] image){
        if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col]==true || image[row][col]!=OriginalColor){
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;

        int adj[][] = {{row,col+1},{row+1,col},{row,col-1},{row-1,col}};
        for(int neighbor[] : adj){
            dfs(visited,neighbor[0],neighbor[1],newColor,image);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        OriginalColor = image[sr][sc];
        boolean[][] visited = new boolean[rows][cols];
        dfs(visited,sr,sc,color,image);
        return image;
    }
}
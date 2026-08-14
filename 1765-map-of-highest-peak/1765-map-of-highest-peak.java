class Solution {
    public int[][] highestPeak(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] positions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] pos : positions){
                int r = node[0] + pos[0];
                int c = node[1] + pos[1];
                if(r>=0 && c>=0 && r<rows && c<cols && mat[r][c]==-1){
                    mat[r][c] = mat[node[0]][node[1]] + 1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return mat;
    }
}
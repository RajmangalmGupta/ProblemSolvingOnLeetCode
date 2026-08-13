class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
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
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}
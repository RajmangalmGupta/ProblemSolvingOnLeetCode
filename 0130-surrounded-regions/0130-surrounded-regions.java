class Solution {
    int rows;
    int cols;
    public void dfs(int row, int col, char[][] board) {
        // Out of bounds
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols)
            return;
        // Stop if not an O
        if (board[row][col] != 'O')
            return;
        // Mark safe
        board[row][col] = '#';

        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        // Traverse first and last column
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);
            dfs(i, cols - 1, board);
        }
        // Traverse first and last row
        for (int j = 0; j < cols; j++) {
            dfs(0, j, board);
            dfs(rows - 1, j, board);
        }
        // Convert surrounded O -> X
        // Restore # -> O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}
class Solution {
    void dfs(int row, int col, char[][] board, int[][] visited, int[] delrow, int[] delcol){
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        //traverse boundaries
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 
            && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, board, visited, delrow, delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        //traverse first row and last row
        for(int j=0;j<m;j++){
            //first row
            if(board[0][j]=='O'){
                dfs(0, j, board, visited, delrow, delcol);
            }
            //last row
            if(board[n-1][j]=='O'){
                dfs(n-1, j, board, visited, delrow, delcol);
            }
        }
        //traverse first col and last col
        for(int i=0;i<n;i++){
            //first col
            if(board[i][0]=='O'){
                dfs(i, 0, board, visited, delrow, delcol);
            }
            //last col
            if(board[i][m-1] == 'O'){
                dfs(i, m-1, board, visited, delrow, delcol);
            }
        }
        //final part - convert unvisited Os to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
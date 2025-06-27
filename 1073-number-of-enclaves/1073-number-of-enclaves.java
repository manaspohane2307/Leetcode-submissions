class Solution {
    void dfs(int row, int col, int[][] grid, int[][] visited, int[] delrow, int[] delcol){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        //travel all neighboring cells
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1
            && visited[nrow][ncol]==0){
                dfs(nrow,ncol,grid,visited,delrow,delcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        //this is multisource dfs as we explore one path
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        //start traversing on boundaries
        //first row and last row
        for(int j=0;j<m;j++){
            //first row
            if(grid[0][j]==1){
                dfs(0,j,grid,visited,delrow,delcol);
            }
            //last row
            if(grid[n-1][j]==1){
                dfs(n-1,j,grid,visited,delrow,delcol);
            }
        }
        //first column and last column
        for(int i=0;i<n;i++){
            //first column
            if(grid[i][0]==1){
                dfs(i,0,grid,visited,delrow,delcol);
            }
            //last column
            if(grid[i][m-1]==1){
                dfs(i,m-1,grid,visited,delrow,delcol);
            }
        }
        //count cells which are 1 and not visited = ans
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
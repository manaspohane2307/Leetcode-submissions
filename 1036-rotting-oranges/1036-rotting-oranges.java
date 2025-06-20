class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Orange> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int fresh_count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    fresh_count++;
                }
                if(grid[i][j]==2){//add rotten oranges into queue and mark visited
                    vis[i][j] = 2;
                    q.add(new Orange(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        int time=0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int count=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time,t);
            q.remove();
            //check neighbours of popped element
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){//checking if fresh and not visited
                    q.add(new Orange(nrow,ncol,time+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if(count != fresh_count){
            return -1;
        }
        return time;
    }
}

class Orange{
    int row;
    int col;
    int time;

    Orange(int row,int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
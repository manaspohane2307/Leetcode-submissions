class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        //traverse and find sources for multi-source bfs and add them in queue and mark visited
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    visited[i][j]=1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
        //for traversing in 4 directions
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};
        //start bfs
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            dist[row][col] = steps;
            q.poll();
            //traverse in 4 directions
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && visited[nrow][ncol]==0){
                    q.add(new Node(nrow,ncol,steps+1));
                    visited[nrow][ncol] = 1;
                }
            }
        }
        return dist;
    }
}

class Node{
    int first,second,third;
    Node(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
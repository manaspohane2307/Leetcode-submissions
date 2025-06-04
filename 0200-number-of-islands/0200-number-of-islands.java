class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    void bfs(char[][] grid, int[][] vis, int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        //for 4 directions
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int qrow = q.peek().first;
            int qcol = q.peek().second;
            q.remove();
            //traverse in 4 directions - neighbours
            for (int i = 0; i < 4; i++) {
                int neighrow = qrow + drow[i];
                int neighcol = qcol + dcol[i];

                if (neighrow >= 0 && neighrow < n && neighcol >= 0 && neighcol < m
                        && vis[neighrow][neighcol] == 0 && grid[neighrow][neighcol] == '1'){
                    vis[neighrow][neighcol] = 1;
                    q.add(new Pair(neighrow, neighcol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }
}
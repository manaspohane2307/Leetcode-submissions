class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        //for traversing horizontally and vertically - 4 directions
        int[] deltaRow = { -1, 0, 1, 0 };
        int[] deltaCol = { 0, 1, 0, -1 };
        dfs(sr, sc, ans, image, color, deltaRow, deltaCol, initialColor);
        return ans;
    }

    //dfs function
    void dfs(int sr, int sc, int[][] ans, int[][] image, int color, int[] deltaRow, int[] deltaCol, int initialColor) {
        ans[sr][sc] = color;//color starting cell with new color
        int n = image.length;
        int m = image[0].length;
        //traverse across exactly 4 neighbours of (sr,sc)
        for (int i = 0; i < 4; i++) {
            int nrow = sr + deltaRow[i];
            int ncol = sc + deltaCol[i];
            //check for valid coordinate
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && image[nrow][ncol] == initialColor //condition for flood fill
                    && ans[nrow][ncol] != color) {
                dfs(nrow, ncol, ans, image, color, deltaRow, deltaCol, initialColor);
                //call dfs with sr and sc as nrow and ncol
            }
        }

    }
}
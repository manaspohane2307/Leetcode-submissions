class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxcount = 0, index=0;
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            int row_count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    row_count++;
                    if(row_count > maxcount){
                        index = i;
                        maxcount = row_count;
                    }
                }
            }
        }
        return new int[]{index, maxcount};
    }
}
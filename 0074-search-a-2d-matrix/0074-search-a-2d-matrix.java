class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            int m = matrix[0].length;
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                if(binarySearch(matrix[i],target)==true){
                    return true;
                }
            }
        }
        return false;
    }
    boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoization(n-1,nums,dp);
    }

    int memoization(int index, int[]arr, int[] dp){
        if(index==0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        //recursive solution
        int pick = arr[index] + memoization(index - 2, arr, dp);
        int notpick = 0 + memoization(index - 1, arr, dp);
        return dp[index] = Math.max(pick, notpick);
    }
}
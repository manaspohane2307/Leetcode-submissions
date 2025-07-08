class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0, right=0;
        int maxlen = 0;
        int zeroes=0;
        while(right < n){
            if(nums[right]==0){
                zeroes++;
            }
            if(zeroes > k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes <= k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        int ans = countSubarraySum(nums,k) - countSubarraySum(nums,k-1);
        return ans;
    }

    int countSubarraySum(int[] nums, int goal){
        int n = nums.length;
        if(goal<0){
            return 0;
        }
        int left=0, right=0, count=0, sum=0;
        while(right < n){
            sum += nums[right]%2;
            while(sum > goal){
                sum -= nums[left]%2;
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }
}
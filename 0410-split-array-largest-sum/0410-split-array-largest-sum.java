class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = nums[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(countPartitions(nums, mid) <= k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        } 
        return low;
    }

    int countPartitions(int[] nums, int maxsum){
        int n = nums.length;
        int partitions=1;
        long subarraysum = 0;
        for(int i=0;i<n;i++){
            if(subarraysum + nums[i] <= maxsum){
                subarraysum += nums[i];
            }
            else{
                partitions++;
                subarraysum = nums[i];
            }
        }
        return partitions; 
    }
}
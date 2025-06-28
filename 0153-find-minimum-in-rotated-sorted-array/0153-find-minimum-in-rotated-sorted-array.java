class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[mid]){//left half is sorted
                ans = Math.min(nums[low], ans);
                low = mid+1;//eliminate left half
            }
            else{//right half is sorted
                ans = Math.min(nums[mid], ans);
                high = mid-1;
            }
        }
        return ans;
    }
}
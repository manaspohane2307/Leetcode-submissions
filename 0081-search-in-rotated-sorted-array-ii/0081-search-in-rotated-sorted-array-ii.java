class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low=0, high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[low] <= nums[mid]){//left half is sorted
                if(nums[low] <= target && target <= nums[mid]){//target in left
                    high = mid-1;
                }
                else{//lies in right half
                    low = mid+1;
                }
            }
            else{//right half is sorted
                if(nums[mid] <= target && target <= nums[high]){//target in right
                    low = mid+1;
                }
                else{//lies in left half
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
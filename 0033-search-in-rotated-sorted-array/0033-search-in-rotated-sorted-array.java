class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;//2 pointer
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {//left part is sorted
                if (nums[low] <= target && target <= nums[mid]) {//target lies in left half
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {//right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {//target lies in right
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
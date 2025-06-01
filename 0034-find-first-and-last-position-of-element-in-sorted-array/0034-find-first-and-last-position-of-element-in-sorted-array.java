class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = searchFirstOccurence(nums,target);
        int last = searchLastOccurence(nums,target);
        int[] ans = {first,last};
        return ans;
    }
    static int searchFirstOccurence(int[] arr, int target){
        int n = arr.length;
        int low=0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == arr[mid]){
                ans = mid;//maybe an answer
                high = mid-1;//move leftwards to find first occurence
            }
            else if(target < arr[mid]){
                high = mid-1;//move leftwards
            }
            else{
                low = mid+1;//move rightwards
            }
        }
        return ans;
    }

    static int searchLastOccurence(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                ans = mid;// maybe an answer
                low = mid + 1;// move leftwards to find first occurence
            } else if (target < arr[mid]) {
                high = mid - 1;// move leftwards
            } else {
                low = mid + 1;// move rightwards
            }
        }
        return ans;
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){//array contains only 1 element
            return nums[0];
        }
        int[] nums1 = new int[n-1];//excluding last element
        int[] nums2 = new int[n-1];//excluding first element
        int count1=0,count2=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                nums2[count2] = nums[i];
                count2++;
            }
            if(i!=n-1){
                nums1[count1] = nums[i];
                count1++;
            }
        }
        return Math.max(spaceoptimization(nums1),spaceoptimization(nums2));
    }
    static int spaceoptimization(int[] arr){
        int n = arr.length;
        int prev=arr[0];
        int prev2=0;

        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1){
                pick += prev2;
            }
            int nonpick = prev;
            int curr = Math.max(pick,nonpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = func(nums, k) - func(nums,k-1);
        return ans;
    }

    int func(int[]nums, int k){
        int n = nums.length;
        int left=0, right=0, count=0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right < n){
            mpp.put(nums[right],mpp.getOrDefault(nums[right],0)+1);
            while(mpp.size()>k){
                mpp.put(nums[left],mpp.get(nums[left])-1);
                if(mpp.get(nums[left])==0){
                    mpp.remove(nums[left]);
                }
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }
}
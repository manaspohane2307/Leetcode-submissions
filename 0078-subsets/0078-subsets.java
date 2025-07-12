class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<subsets;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) != 0){//equal to 1
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
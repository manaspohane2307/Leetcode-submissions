class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int j=0;j<n;j++){
            if(nums[j]==key){
                for(int i=0;i<n;i++){
                    if(Math.abs(i-j) <= k){
                        set.add(i);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
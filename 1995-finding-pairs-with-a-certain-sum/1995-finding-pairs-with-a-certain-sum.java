class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> mpp;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.mpp = new HashMap<>();
        //put nums2 elements in map
        for (int it : nums2) {
            mpp.put(it, mpp.getOrDefault(it, 0) + 1);
        }
    }

    public void add(int index, int val) {
        //decrease frequency of old value
        int oldvalue = nums2[index];
        mpp.put(oldvalue, mpp.getOrDefault(oldvalue,0)-1);
        if(mpp.get(oldvalue)==0){
            mpp.remove(oldvalue);
        }
        nums2[index] += val;
        int newval = nums2[index];
        mpp.put(newval, mpp.getOrDefault(newval,0)+1);
    }

    public int count(int tot) {
        int count=0;
        for(int num : nums1){
            int comp = tot-num;
            count += mpp.getOrDefault(comp,0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
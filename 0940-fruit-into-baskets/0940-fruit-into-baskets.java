class Solution {
    public int totalFruit(int[] fruits) {
        int left=0, right=0, maxlen=0, k=2;
        int n = fruits.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right<n){
            mpp.put(fruits[right], mpp.getOrDefault(fruits[right],0)+1);
            if(mpp.size() > k){
                mpp.put(fruits[left], mpp.get(fruits[left])-1);
                if(mpp.get(fruits[left])==0){
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            if(mpp.size() <= k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();//store character and latest index
        int left=0, right=0;
        int maxlen=0;
        while(right < n){//traverse through string
            if(mpp.containsKey(s.charAt(right))){
                left = Math.max(left, mpp.get(s.charAt(right))+1);//move left forward to next to right
            }
            mpp.put(s.charAt(right), right);//store latest index of right
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}
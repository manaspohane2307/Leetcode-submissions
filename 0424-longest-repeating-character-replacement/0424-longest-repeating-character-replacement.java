class Solution {
    public int characterReplacement(String s, int k) {
        int left=0, right=0;
        int maxlen=0, maxf=0;
        int n = s.length();
        int[] hash = new int[26];
        while(right<n){
            hash[s.charAt(right)-'A']++;
            maxf = Math.max(maxf, hash[s.charAt(right)-'A']);
            if((right-left+1)-maxf > k){
                hash[s.charAt(left) - 'A']--;
                maxf = 0;
                left++;
            }
            if((right-left+1)-maxf <= k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}
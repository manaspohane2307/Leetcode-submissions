class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int sum = 0;
        int pow=1;
        int count=0;
        //iterate from right to left - LSB to MSB
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                count++;
            }
            else{
                if(pow <= k && sum+pow <= k){
                    sum += pow;
                    count++;
                }
            }
            //update power only if smaller than k - do not break from loop to include leading zeroes
            if(pow<=k){
                pow = pow*2;
            }
        }
        return count;
    }
}
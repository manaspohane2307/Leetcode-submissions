class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length() < t.length()){
            return "";
        }
        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int left=0, right=0, minlen = Integer.MAX_VALUE, sIndex=0;
        int required = t.length();
        while(right < s.length()){
            if(freq[s.charAt(right)] > 0){//got matching character of t
                required--;
            }
            freq[s.charAt(right)]--;//reduce its count
            right++;//move right forward
            //when all characters matched
            while(required==0){
                if(right-left < minlen){
                    minlen = right-left;
                    sIndex = left;
                }
                //contarcting window
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0){
                    required++;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(sIndex, sIndex+minlen);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int[] hasharray = new int[256];//will store index at which each character occcurs
        for (int i = 0; i < 256; i++)
            hasharray[i] = -1;//initialize all values to -1

        while (right < n) {
            if (hasharray[s.charAt(right)] != -1) {//found in map
                if (hasharray[s.charAt(right)] >= left) {
                    left = hasharray[s.charAt(right)] + 1;//update left pointer
                }
            }
            maxlen = Math.max(maxlen, right - left + 1);
            hasharray[s.charAt(right)] = right;//store index
            right++;//update right pointer
        }
        return maxlen;
    }
}
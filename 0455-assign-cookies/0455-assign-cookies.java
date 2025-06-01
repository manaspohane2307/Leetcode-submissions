class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;//size
        int r=0;//greed
        while(l<m && r<n){
            if(g[r]<=s[l]){//greed satisfied
                r++;//move to next child
            }
            l++;//check next size
        }
        return r;
    }
}
class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }
        int maxodd=Integer.MIN_VALUE;
        int mineven=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val = mpp.get(s.charAt(i));
            if(val%2==1){
                maxodd = Math.max(maxodd,val);
            }
            else{
                mineven = Math.min(mineven,val);
            }
        }
        return maxodd-mineven;
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0, rsum=0, maxsum=0;
        int n = cardPoints.length;
        for(int i=0;i<k;i++){
            lsum += cardPoints[i];
        }
        maxsum = lsum;
        int rindex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[rindex];
            rindex--;
            maxsum = Math.max(maxsum, lsum+rsum);
        }
        return maxsum;
    }
}
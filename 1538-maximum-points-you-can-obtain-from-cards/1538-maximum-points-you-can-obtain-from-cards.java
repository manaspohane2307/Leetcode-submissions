class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftsum=0;
        int rightsum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){//sum of first k elements starting from left
            leftsum += cardPoints[i];
        }
        maxsum = leftsum;
        int rightindex=n-1;
        for(int i=k-1;i>=0;i--){//shrinking left side window and expanding right side window
            leftsum -= cardPoints[i];//decrease left sum
            rightsum += cardPoints[rightindex];//increase right sum
            rightindex--;//update right index
            maxsum = Math.max(maxsum, leftsum+rightsum);
        }
        return maxsum;
    }
}
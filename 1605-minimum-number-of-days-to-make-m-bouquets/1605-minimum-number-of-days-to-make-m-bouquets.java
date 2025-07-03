class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long n = bloomDay.length;
        if((long)m*k > n){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini, high = maxi;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, mid, m, k)==true){
                high = mid-1;//we want minimum days
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    boolean isPossible(int[] bloomDay, int d, int m, int k){
        int count=0, bouq = 0;
        int n = bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= d){
                count++;
                if(count==k){
                    bouq++;
                    count=0;
                }
            }
            else{
                count = 0;
            }
        }
        return (bouq>=m);
    }
}
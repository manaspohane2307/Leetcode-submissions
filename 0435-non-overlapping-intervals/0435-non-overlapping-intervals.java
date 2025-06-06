class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new IntervalComparator());
        int count=1;//included first interval
        int lastend = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= lastend){//>= allowed only in this problem
                count++;
                lastend = intervals[i][1];
            }
        }
        return n-count;
    }
}

class IntervalComparator implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return Integer.compare(a[1],b[1]);
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int count=0;
        int total = n+m;
        int ind2 = total/2;
        int ind1 = ind2 - 1;
        int inde1 = -1, inde2 = -1;

        int i=0, j=0;
        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                if(count==ind1) inde1 = nums1[i];
                if(count==ind2) inde2 = nums1[i];
                count++;
                i++;
            }
            else{
                if(count==ind1) inde1 = nums2[j];
                if(count==ind2) inde2 = nums2[j];
                count++;
                j++;
            }
        }
        //copy left out elements
        while(i<n){
            if(count==ind1) inde1 = nums1[i];
                if(count==ind2) inde2 = nums1[i];
                count++;
                i++;
        }
        while(j<m){
            if(count==ind1) inde1 = nums2[j];
                if(count==ind2) inde2 = nums2[j];
                count++;
                j++;
        }
        if(total % 2 == 1){
            return (double)(inde2);
        }
        else{
            return (double)((double)(inde1 + inde2)) / 2.0;
        }
    }
}
class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(arr[i], mpp.getOrDefault(arr[i],0)+1);
        }
        int maxfreqelem = -1;
        for(Integer key : mpp.keySet()){
            int freq = mpp.get(key);
            if(freq==key){
                maxfreqelem = Math.max(maxfreqelem, key);
            }
        }
        return maxfreqelem;
    }
}
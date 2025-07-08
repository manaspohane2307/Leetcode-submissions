class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxlen = 0;
        int left = 0, right = 0;
        while (right < n) {
            mpp.put(fruits[right], mpp.getOrDefault(fruits[right], 0) + 1);
            if (mpp.size() <= 2) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            while (mpp.size() > 2) {
                mpp.put(fruits[left], mpp.get(fruits[left]) - 1);
                if (mpp.get(fruits[left]) == 0) {
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            right++;
        }
        return maxlen;
    }
}
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int currnum=1;
        for(int i=0;i<n;i++){
            ans.add(currnum);//add 1
            if(currnum*10 <= n){//first put digits having 0's
                currnum = currnum*10;
            }
            else{//when last digit is 9 or when currnum>=n then remove last digit and increase currnum by 1 
                while(currnum % 10 == 9 || currnum >= n){
                    currnum = currnum/10;
                }
                currnum += 1;
            }
        }
        return ans;
    }
}
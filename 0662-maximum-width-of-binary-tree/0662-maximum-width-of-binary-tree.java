/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min_id = q.peek().second;
            int first = 0, last=0;
            for(int i=0;i<size;i++){
                int currid = q.peek().second - min_id;
                TreeNode temp = q.peek().first;
                q.poll();
                if(i==0) first = currid;
                if(i==size-1) last = currid;
                if(temp.left != null){
                    q.add(new Pair(temp.left,2*currid+1));
                }
                if(temp.right != null){
                    q.add(new Pair(temp.right,2*currid+2));
                }
            }
            ans = Math.max(ans,last-first+1); 
        }
        return ans;
    }
}
class Pair<K,T>{
    K first;
    T second;
    Pair(K first, T second){
        this.first = first;
        this.second = second;
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(size,0));
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                int index=0;
                if(flag==true){
                    index = i; 
                }
                else{
                    index = size-i-1;
                }
                level.set(index, temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            ans.add(level);
            flag = !flag;
        }
        return ans;
    }
}
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
    TreeNode first;
    TreeNode prev;
    TreeNode middle;
    TreeNode last;

    void inorder(TreeNode root){
        if(root==null){//base case
            return;
        }
        inorder(root.left);

        if(prev != null && root.val < prev.val){
            if(first == null){//first violation
                first = prev;
                middle = root;
            }
            else{//second violation
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            //swap(first.val, last.val);
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!=null && middle!=null){
            //swap(first.val, middle.val);
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
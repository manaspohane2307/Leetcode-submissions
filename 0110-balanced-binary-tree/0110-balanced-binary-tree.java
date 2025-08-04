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
    public boolean isBalanced(TreeNode root) {
        int ans = balancedHeight(root);
        if(ans==-1){
            return false;
        }
        return true;
    }
    int balancedHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftH = balancedHeight(root.left);
        if(leftH==-1){
            return -1;
        }
        int rightH = balancedHeight(root.right);
        if(rightH==-1){
            return -1;
        }
        int diff = Math.abs(rightH-leftH);
        if(diff>1){
            return -1;
        }
        return 1 + Math.max(leftH, rightH);
    }
}
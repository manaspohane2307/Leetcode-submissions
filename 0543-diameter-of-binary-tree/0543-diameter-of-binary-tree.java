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
    int maxd;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxd; 
    }
    int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftH = diameter(root.left);
        int rightH = diameter(root.right);
        maxd = Math.max(maxd, leftH+rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
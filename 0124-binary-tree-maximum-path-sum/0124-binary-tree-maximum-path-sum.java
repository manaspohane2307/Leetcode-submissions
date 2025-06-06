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
    public int maxPathSum(TreeNode root) {
        int[] maxsum = new int[1];
        maxsum[0] = Integer.MIN_VALUE;
        int ans = maxSumDown(root, maxsum);
        return maxsum[0];
    }
    int maxSumDown(TreeNode root, int[] maxsum){
        if(root==null){
            return 0;
        }
        int leftsum = Math.max(0,maxSumDown(root.left,maxsum));
        int rightsum = Math.max(0,maxSumDown(root.right,maxsum));
        maxsum[0] = Math.max(maxsum[0], leftsum + rightsum + root.val);
        return Math.max(leftsum,rightsum)+root.val;
    }
}
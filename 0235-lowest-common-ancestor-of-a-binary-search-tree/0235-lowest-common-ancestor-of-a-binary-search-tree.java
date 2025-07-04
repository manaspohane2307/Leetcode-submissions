/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        int curr = root.val;
        if(curr < p.val && curr < q.val){//move right
            return lowestCommonAncestor(root.right,p,q);
        }
        if(curr > p.val && curr > q.val){//move left
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;//cant move either left or right thus its lca
    }
}
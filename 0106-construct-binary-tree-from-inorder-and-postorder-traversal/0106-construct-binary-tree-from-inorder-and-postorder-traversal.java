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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            mpp.put(inorder[i],i);
        }
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mpp);
    }

    TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> mpp){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);//root node
        int inRoot = mpp.get(postorder[postEnd]);//index of root in inorder
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inRoot-1, mpp);

        root.right = buildTree(postorder, postStart+numsLeft, postEnd-1, inorder, inRoot+1, inEnd, mpp);

        return root;
    }
}
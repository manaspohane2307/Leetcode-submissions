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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            mpp.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mpp);

        return root;
    }

    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> mpp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);//root is always first of preorder

        int inRoot = mpp.get(root.val);//fetch index of that root in inorder array

        int numsLeft = inRoot - inStart;//left side elements of root in inorder array

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, mpp);

        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, mpp);

        return root;
    }
}
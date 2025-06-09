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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        rootToLeaf(ans, root, sb);
        return ans;
    }

    void rootToLeaf(List<String> ans, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {//leaf node encountered
            ans.add(sb.toString());
        } else {
            sb.append("->");//add arrow as not on leaf
            rootToLeaf(ans, root.left, sb);
            rootToLeaf(ans, root.right, sb);
        }
        sb.setLength(len);//for other path restore sb to before leaf
    }
}
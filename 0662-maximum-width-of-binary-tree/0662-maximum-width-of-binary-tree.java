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
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();//pair stores node and its index
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().y;//min index in a level
            int first=0, last=0;
            for (int i = 0; i < size; i++) {
                int currid = q.peek().y - mmin;
                TreeNode node = q.peek().x;
                q.poll();
                if (i == 0) {
                    first = currid;
                }
                if (i == size - 1) {
                    last = currid;
                }
                if (node.left != null) {
                    q.add(new Pair(node.left, currid * 2 + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, currid * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}

class Pair {
    TreeNode x;
    int y;

    Pair(TreeNode x, int y) {
        this.x = x;
        this.y = y;
    }
}
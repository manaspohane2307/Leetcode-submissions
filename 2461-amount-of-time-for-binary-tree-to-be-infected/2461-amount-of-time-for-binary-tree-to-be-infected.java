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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();//map node to parents
        TreeNode target = bfsToMapParents(root, mpp, start);//find addr of node and map parents to node
        int max_time = findMaxDistance(mpp, target);
        return max_time;
    }

    TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> mpp, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode res = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val == start) {
                res = temp;
            }
            if (temp.left != null) {
                mpp.put(temp.left, temp);
                q.add(temp.left);
            }
            if (temp.right != null) {
                mpp.put(temp.right, temp);
                q.add(temp.right);
            }
        }
        return res;
    }

    int findMaxDistance(HashMap<TreeNode,TreeNode> mpp, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        visited.put(target, 1);
        int maxtime = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    flag = 1;
                    q.add(node.left);
                    visited.put(node.left, 1);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    flag = 1;
                    q.add(node.right);
                    visited.put(node.right, 1);
                }
                if (mpp.get(node) != null && visited.get(mpp.get(node)) == null) {
                    flag = 1;
                    q.add(mpp.get(node));
                    visited.put(mpp.get(node), 1);
                }
            }
            if (flag == 1) {
                maxtime++;
            }
        }
        return maxtime;
    }
}
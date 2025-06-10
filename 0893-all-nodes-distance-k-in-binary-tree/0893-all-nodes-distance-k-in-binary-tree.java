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
    void markParents(TreeNode root, Map<TreeNode,TreeNode> parent_track, TreeNode target){//map contains<node,parent>
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parent_track.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root,parent_track,root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);//starting node for bfs
        visited.put(target,true);
        int dist=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k){//bfs to go only upto k
                break;
            }
            dist++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left)==null){//check left
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right)==null){//check right
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr))==null){//parent node exists and not yet visited
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){//queue contains all nodes at dist k
            TreeNode curr = q.poll();
            ans.add(curr.val);
        }
        return ans;
    }
}
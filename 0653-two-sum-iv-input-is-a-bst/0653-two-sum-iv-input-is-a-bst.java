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
class BSTIterator{
    Stack<TreeNode> st = new Stack<TreeNode>();
    boolean reverse = true;

    //constructor
    BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }

    boolean hasNext(){
        return !st.isEmpty();
    }

    int next(){
        TreeNode temp = st.pop();
        if(reverse==false){
            pushAll(temp.right);
        }
        else{
            pushAll(temp.left);
        }
        return temp.val;
    }

    void pushAll(TreeNode root){
        while(root != null){
            st.push(root);
            if(reverse==true){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        //next
        BSTIterator l = new BSTIterator(root,false);
        //before
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j < k){
                i = l.next();//move next
            }
            else{
                j = r.next();//move before
            }
        }
        return false;
    }
}
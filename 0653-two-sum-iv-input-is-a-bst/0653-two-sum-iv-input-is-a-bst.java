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
    public boolean findTarget(TreeNode root, int k) {
       List<Integer> in=new ArrayList<>();
       inorder(root,in); 
       int sum=0;
       for(int i=0;i<2;i++){
        sum+=in.get(i);
       }
       if(sum==k){
        return true;
       }
       for(int j=2;j<in.size();j++){
        sum+=in.get(j)-in.get(j-2);
        if(sum==k){
            return true;
        }
       }
       return false;
    }
    public void inorder(TreeNode root,List<Integer> in){
        if(root==null){
            return ;
        }
        inorder(root.left,in);
        in.add(root.val);
        inorder(root.right,in);
    }
}
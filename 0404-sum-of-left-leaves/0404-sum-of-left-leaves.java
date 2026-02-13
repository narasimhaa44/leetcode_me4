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
    public void inhelper(TreeNode node,ArrayList<Integer> leaf){
        if(node==null){
            return;
        }
        inhelper(node.left,leaf);
        if(node.left!=null && node.left.left==null && node.left.right==null){
            leaf.add(node.left.val);
            // inhelper(node.left,leaf);
        }
        inhelper(node.right,leaf);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        ArrayList<Integer> leaf=new ArrayList<>();
        inhelper(root,leaf);
        int sum=0;
        for(int k:leaf){
            sum+=k;
        }
        return sum;
    }
}
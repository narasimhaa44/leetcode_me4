// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public void ways(ArrayList<String> adj,StringBuilder sb,TreeNode node){
//         if(node==null){
//                 return ;
//         }
//         int len=sb.length();
//         sb.append(node.val);
//         if(node.left==null && node.right==null){
//             adj.add(node.val);
//         }
//         else{
//             ways(adj,sb,node.left);
//             ways(adj,sb,node.right);
//         }
//         sb.setLength(len);
//     }
//     public int sumNumbers(TreeNode root) {
//         ArrayList<String> adj=new ArrayList<>();
//         StringBuilder sb=new StringBuilder();
//         ways(adj,sb,root);
//         int sum=0;
//         for(String s:adj){
//             int p=Integer.ParseInt(s);
//             sum+=p;
//         }
//         return sum;
//     }
// }
class Solution {
    public void ways(ArrayList<String> adj, StringBuilder sb, TreeNode node) {
        if (node == null) return;
        int len = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            adj.add(sb.toString());
        } else {
            ways(adj, sb, node.left);
            ways(adj, sb, node.right);
        }
        sb.setLength(len);
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<String> adj = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        ways(adj, sb, root);
        int sum = 0;
        for (String s : adj) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}

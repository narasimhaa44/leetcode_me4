/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                Node p=q.poll();
                if(i!=l-1){
                        p.next=q.peek();
                }
                else {
                    p.next=null;
                }
                if(p.left!=null){
                        q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
        }
        return root;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// class Solution {
//     public List<Integer> preorder(Node root) {
        
//     }
// }
class Solution {
    public void getPreorder(Node n, List<Integer> al) {
        if (n == null)
            return;
        al.add(n.val);
        for (Node child : n.children)
            getPreorder(child, al);
    }
    
    
    public List<Integer> preorder(Node root) {
        List<Integer> al = new ArrayList<>();
        getPreorder(root, al);
        return al;
    }
}
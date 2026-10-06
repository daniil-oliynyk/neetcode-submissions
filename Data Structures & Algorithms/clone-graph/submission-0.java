/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> hm = new HashMap<>();
        return dfs(node,hm);
    }

    public Node dfs(Node node, HashMap<Node,Node> hm){
        if (node == null) {
            return null;
        }
        if (hm.containsKey(node)) {
            return hm.get(node);
        }

        Node newnode = new Node(node.val);
        hm.put(node,newnode);
        for(Node nb: node.neighbors) {
            newnode.neighbors.add(dfs(nb,hm));
        }
        return newnode;
    }
}
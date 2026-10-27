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

        if(node == null) return null;

        Queue<Node> q = new LinkedList<>();

        Node newNode = new Node(node.val);

        hm.put(node,newNode);

        q.add(node);

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node neighbor : n.neighbors) {
                if (!hm.containsKey(neighbor)) {
                    hm.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                hm.get(n).neighbors.add(hm.get(neighbor));                
            }


        }
        
        return hm.get(node);

    }

    
}
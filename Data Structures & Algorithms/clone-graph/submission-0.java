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
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        return clone(node,map);
    }
    private Node clone(Node node,HashMap<Node,Node> map)
    {
        if(map.containsKey(node)) return map.get(node);
        Node n=new Node(node.val);
        map.put(node,n);
        for(Node temp:node.neighbors)
        {
            n.neighbors.add(clone(temp,map));
        }
        return n;
    }
}
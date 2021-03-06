/*
// Definition for a Node.
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
        Map<Node, Node> map = new HashMap<>();
        
        return dfs(node, map);
    }
    
    public Node dfs(Node node, Map<Node, Node> lookup) {
        if(node == null)
            return null;
        
        if(lookup.containsKey(node))
            return lookup.get(node);
        
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        
        for(Node n : node.neighbors)
            clone.neighbors.add(dfs(n, lookup));
        
        return clone;
    }
}

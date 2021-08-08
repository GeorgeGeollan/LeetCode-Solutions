/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Node cur = head;
        HashMap<Node, Node> node = new HashMap<>();

        while(cur != null)
        {
            node.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while(cur != null)
        {
            node.get(cur).next = node.get(cur.next);
            node.get(cur).random = node.get(cur.random);
            cur = cur.next;
        }

        return node.get(head);
    }
}

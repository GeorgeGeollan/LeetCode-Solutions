/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val > l2.val)
                    return 1;
                
                else if(l1.val == l2.val)
                    return 0;
                
                else
                    return -1;
            }
        });
        
        for(ListNode list: lists) {
            if(list != null)
                pq.add(list);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        while(!pq.isEmpty()) {
            root.next = pq.poll();
            root = root.next;
            if(root.next != null)
                pq.add(root.next);
        }
        
        return dummy.next;
    }
}

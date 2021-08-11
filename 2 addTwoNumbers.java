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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode n = new ListNode();
        ListNode ptr = n;

        while(l1 != null && l2 != null)
        {
            int num1 = l1.val;
            int num2 = l2.val;

            int sum = (num1 + num2 + count) % 10;
            n.next = new ListNode(sum);
            count = (num1 + num2 + count) / 10;
            l1 = l1.next;
            l2 = l2.next;
            n = n.next;
        }

        while(l1 != null)
        {
            int sum = (l1.val + count) % 10;
            n.next = new ListNode(sum);
            count = (l1.val + count) / 10;
            l1 = l1.next;
            n = n.next;
        }

        while(l2 != null)
        {
            int sum = (l2.val + count) % 10;
            n.next = new ListNode(sum);
            count = (l2.val + count) / 10;
            l2 = l2.next;
            n = n.next;
        }

        if(count == 1)
            n.next = new ListNode(count);

        return ptr.next;
    }
}
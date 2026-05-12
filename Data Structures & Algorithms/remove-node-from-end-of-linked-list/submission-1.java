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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode l1 = head;
        while (l1 != null) {
            size++;
            l1 = l1.next;
        }
        int target = size - n;
        if (target == 0) {
            return head.next;
        }
        target--;
        ListNode l2 = head;

        while (target-- != 0) {
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return head;
    }
}

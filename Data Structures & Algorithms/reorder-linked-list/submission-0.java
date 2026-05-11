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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head, l2 = slow.next;
        slow.next = null;

        ListNode rev = reverseLL(l2);

        while (l1 != null && rev != null) {
            ListNode temp1 = l1;
            ListNode temp2 = rev;
            l1 = l1.next;
            temp1.next = rev;
            rev = rev.next;
            temp2.next = l1;
        }
    }

    public ListNode reverseLL(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr!= null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
}
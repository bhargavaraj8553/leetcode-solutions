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
    public ListNode rotateRight(ListNode head, int k) {
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
        ListNode tempNode = head;
        ListNode tail = head;
        int count = 1;
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        tail.next = head;
        while (tempNode.next != null) {
            if (count == length- k) {
                break;
            }
            count++;
            tempNode = tempNode.next;
        }
        ListNode newHead = tempNode.next;
        tempNode.next = null;
        return newHead;
    }
}
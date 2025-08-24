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
    public ListNode reverseList(ListNode head) {
        ListNode tempNode = head;
        ListNode prev = null;
        while (tempNode!=null){
            ListNode tempNodeNext = tempNode.next;
            tempNode.next = prev;
            prev = tempNode;
            tempNode = tempNodeNext;
        }
        return prev;
    }
}
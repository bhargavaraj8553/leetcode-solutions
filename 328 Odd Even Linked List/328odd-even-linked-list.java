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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode evenPosNode = head.next;
        ListNode oddPosNode = head;
        ListNode evenHead = head.next;
        
        while (evenPosNode!=null && evenPosNode.next!=null){
            oddPosNode.next = oddPosNode.next.next;
            evenPosNode.next = evenPosNode.next.next;
            oddPosNode= oddPosNode.next;
            evenPosNode= evenPosNode.next;
        }
        oddPosNode.next= evenHead;
        return head;
    }
}
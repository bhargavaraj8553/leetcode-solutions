/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
    */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // so basically in this we have this trick that either we need to move the both nodes at same position to start with to compatre or either swap the heads after traversing one which will reduce the distance between two 
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        if (tempA == null && tempB == null) {
            return null;
        } else return tempA;
    }
}
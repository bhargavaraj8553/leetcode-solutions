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
    public ListNode sortList(ListNode head) {
        /**
        Base case in sortList:
        if (head == null || head.next == null) return head;
        → handles empty & single node lists.
        
        Splitting at middle using getMiddleOfLinkedlist → then recursing into sortList.
        
        Merging two sorted lists using dummy node + pointer curr.
        
        Time complexity: O(n log n).
        
        Space complexity: O(log n) (recursion stack).
         **/
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddleOfLinkedlist(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeTwoSortedLinkedList(left, right);
    }

    private ListNode mergeTwoSortedLinkedList(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;

            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummyHead.next;
    }

    private ListNode getMiddleOfLinkedlist(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

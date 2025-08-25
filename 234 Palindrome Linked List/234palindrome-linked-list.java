class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) { //to get the first middle value of a linked list this way is used to get that info
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode newHeadAfterReverse = reverseLinkedList(slow.next);
        slow = head;
        while (newHeadAfterReverse != null) {
            if (newHeadAfterReverse.val != slow.val) {
                return false;
            }
            newHeadAfterReverse = newHeadAfterReverse.next;
            slow = slow.next;
        }
        reverseLinkedList(slow.next);
        return true;

    }


    private static ListNode reverseLinkedList(ListNode head) {
        ListNode tempNode = head;
        ListNode prev = null;
        while (tempNode != null) {
            ListNode nextNode = tempNode.next;
            tempNode.next = prev;
            prev = tempNode;
            tempNode = nextNode;
        }
        return prev;
    }
}
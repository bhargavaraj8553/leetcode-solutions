public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        slow = head;
        while (fast!= null && fast.next!=null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}
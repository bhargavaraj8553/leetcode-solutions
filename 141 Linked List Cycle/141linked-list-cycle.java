public class Solution {
    public boolean hasCycle(ListNode head) {
        // floy's cycle detection algorithm 
        //basically keep a slow and a fast pointer in any question and if it is a loop then after some cycles both will be at same pointer if it is not a loop they wont point at same then 
        ListNode slowNode = head, fastNode = head;
        while (slowNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(fastNode ==null) return false;
            else if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }
}
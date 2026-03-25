class Solution {

    /*
    =========================================================
    🧠 INTUITION
    =========================================================
    Problem: Merge K Sorted Linked Lists

    Brute force:
    - Collect all nodes → sort → rebuild → O(n log n)

    Optimized:
    - Use Divide & Conquer (like merge sort)
    - Merge lists pair by pair

    =========================================================
    💡 HOW TO THINK
    =========================================================
    Treat this exactly like merge sort:

    - Each list = sorted unit
    - Divide lists into halves
    - Merge left half + right half

    =========================================================
    */

    public ListNode mergeKLists(ListNode[] lists) {

        // Edge case: no lists
        if (lists.length == 0) return null;

        // Start divide & conquer
        return partitionAndMerge(lists, 0, lists.length - 1);
    }

    /*
    =========================================================
    DIVIDE STEP
    =========================================================
    Recursively divide the list of lists

    Base condition:
    When only ONE list remains → return it
    */
    private ListNode partitionAndMerge(ListNode[] lists, int left, int right) {

        /*
        =========================================================
        🧠 BASE CONDITION
        =========================================================
        When left == right:
        → Only one list is left
        → Already sorted
        → Just return it

        This is the "smallest unit" of problem
        */

        if (left == right) {
            return lists[left];
        }

        // Divide into two halves
        int mid = left + (right - left) / 2;

        // Recursively solve left half
        ListNode listNode1 = partitionAndMerge(lists, left, mid);

        // Recursively solve right half
        ListNode listNode2 = partitionAndMerge(lists, mid + 1, right);

        // Merge both halves
        return mergeTwoLinkedLists(listNode1, listNode2);
    }

    /*
    =========================================================
    MERGE STEP
    =========================================================
    Merge two sorted linked lists

    Similar to merge step in merge sort
    */
    private ListNode mergeTwoLinkedLists(ListNode listNode1, ListNode listNode2) {

        // If one list is empty → return the other
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;

        /*
        Compare current nodes
        Pick smaller one and move forward
        */
        if (listNode1.val < listNode2.val) {

            // choose listNode1
            listNode1.next = mergeTwoLinkedLists(listNode1.next, listNode2);
            return listNode1;

        } else {

            // choose listNode2
            listNode2.next = mergeTwoLinkedLists(listNode1, listNode2.next);
            return listNode2;
        }

        /*
        =========================================================
        🚨 YOUR PAST MISTAKES (IMPORTANT REVISION)
        =========================================================

        ❌ MISTAKE #1:
        Used right = lists.length

        👉 OUT OF BOUNDS

        ✅ FIX:
        right = lists.length - 1

        -----------------------------------------------------

        ❌ MISTAKE #2:
        Used base condition:
        left >= right

        👉 Can cause invalid index access

        ✅ FIX:
        left == right (exactly one list)

        -----------------------------------------------------

        ❌ MISTAKE #3:
        Forgot return in else block

        👉 Causes null return → wrong result

        -----------------------------------------------------

        ❌ MISTAKE #4:
        Confusion about base condition

        👉 Clarification:
        Base case = smallest solvable unit
        Here → single list

        -----------------------------------------------------

        ❌ MISTAKE #5:
        Thinking linearly instead of divide & conquer

        👉 This problem = merge sort pattern

        =========================================================
        */
    }

    /*
    =========================================================
    ⏱️ TIME & SPACE COMPLEXITY
    =========================================================

    Let:
    k = number of lists
    n = total number of nodes

    Time:
    O(n log k)
    - log k levels (divide)
    - merging takes O(n)

    Space:
    O(log k) recursion stack

    =========================================================
    🔥 FINAL RULE
    =========================================================

    Merge K Lists → Divide & Conquer
    (same pattern as merge sort)

    =========================================================
    */
}
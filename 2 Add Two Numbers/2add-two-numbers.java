class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    /*
        # \U0001f4d8 DSA LinkedList Notes (Interview Quick Recall)

---

## Q1 – Add Two Numbers (LeetCode 2)

### \U0001f539 Approach 1 – In-place Modification (User’s Version)

**Idea**: Use `l1` as result list, update values directly, attach remaining nodes of `l2` if needed, manage carry.

* Traverse both lists, summing nodes.
* Update values of `l1`.
* If one list ends early, continue with the other.
* Append new node if carry remains.

**Pros**:

* O(1) extra space.
* Works fine.

**Cons**:

* Mutates input list (`l1`).
* Repetitive logic (two while loops).
* Less clean in code.

✅ Optimized for space, but not elegant.

---

### \U0001f539 Approach 2 – Dummy Head (Standard & Preferred)

**Idea**: Use a dummy node to build new result list, handle carry cleanly in a single loop.

* Loop while (`l1 != null || l2 != null || carry != 0`).
* Add node values + carry.
* Compute new carry.
* Create new node with `sum % 10`.
* Move pointers.
* Return `dummy.next`.

**Pros**:

* Cleaner & shorter.
* Doesn’t modify inputs.
* Handles all cases in one loop.

**Cons**:

* O(n) extra space (new list).

✅ Interview standard solution.

---

### \U0001f511 Recall Tip

* In-place = tricky but space saving.
* Dummy head = clean, universal, interviewer-friendly.

\U0001f449 In 90% of interviews: **Use Dummy Head**.

     */
     ListNode dummyHead = new ListNode(0);
     ListNode curr = dummyHead;
     int carry = 0;

     while(l1 != null || l2 != null || carry != 0){
        int digitSum = carry;
        if (l1 != null){
            digitSum+= l1.val;
            l1 = l1.next;
        }
        if (l2 != null){
            digitSum+= l2.val;
            l2 = l2.next;
        }

         carry = digitSum/10;
         digitSum = digitSum%10;
         curr.next = new ListNode(digitSum);
         curr = curr.next;
     }
     return dummyHead.next;

//        ListNode tempL1 = l1;
//        ListNode tempL2 = l2;
//        int carry = 0;
//        ListNode prev = tempL1;
//        while (tempL1 != null && tempL2 != null) {
//            int digitSum = tempL1.val + tempL2.val + carry;
//            carry = digitSum / 10;
//            tempL1.val = digitSum % 10;
//            prev = tempL1;
//            tempL1 = tempL1.next;
//            tempL2 = tempL2.next;
//        }
//        if (tempL1 == null) {
//            while (tempL2 != null) {
//                int digitSum = tempL2.val + carry;
//                prev.next = new ListNode(digitSum % 10);
//                carry = digitSum / 10;
//                prev = prev.next;
//                tempL2 = tempL2.next;
//            }
//            if (carry == 1) {
//                prev.next = new ListNode(carry);
//            }
//            return l1;
//        } else {
//            while (tempL1 != null) {
//                int digitSum = tempL1.val + carry;
//                tempL1.val = digitSum % 10;
//                carry = digitSum / 10;
//                prev = tempL1;
//                tempL1 = tempL1.next;
//            }
//            if (carry == 1) {
//                prev.next = new ListNode(carry);
//            }
//            return l1;
//        }
    }
}
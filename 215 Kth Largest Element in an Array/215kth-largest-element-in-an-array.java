class Solution {

    /*
    =========================================================
    🧠 INTUITION
    =========================================================
    Problem: Find Kth Largest Element

    Brute force:
    - Sort array → pick (n-k)th → O(n log n)

    Optimized (Heap):
    - Maintain a MIN HEAP of size k
    - This heap will always store the k largest elements seen so far

    WHY MIN HEAP?
    - Smallest among k largest sits at root
    - If a bigger element comes → remove smallest → keep only top k

    =========================================================
    💡 HOW TO THINK (INTERVIEW KEY)
    =========================================================
    Whenever you see:
    - "Kth largest"
    - "Top K elements"

    👉 Think:
    "Can I maintain a heap of size K?"

    =========================================================
    */

    public int findKthLargest(int[] nums, int k) {

        // Min Heap (default in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        /*
        =========================================================
        🚀 APPROACH
        =========================================================
        Step 1: Traverse array
        Step 2: Add element to heap
        Step 3: If size > k → remove smallest
        Step 4: Heap contains k largest elements
        Step 5: Root = kth largest
        */

        for (int n : nums) {

            // Add element
            minHeap.add(n);

            // Keep heap size limited to k
            if (minHeap.size() > k) {

                // Remove smallest element
                // (we only want k largest elements)
                minHeap.remove();
            }
        }

        /*
        =========================================================
        🧠 FINAL STATE
        =========================================================
        Heap contains k largest elements

        Example:
        nums = [3,2,1,5,6,4], k=2

        Heap evolution:
        [3]
        [2,3]
        [2,3] → remove 1
        [3,5]
        [5,6]
        [5,6]

        Root = 5 → 2nd largest
        */

        return minHeap.peek();

        /*
        =========================================================
        ⏱️ TIME & SPACE COMPLEXITY
        =========================================================

        Time:
        O(n log k)
        - Insert: log k
        - Done n times

        Space:
        O(k)

        =========================================================
        🚨 COMMON MISTAKES (IMPORTANT REVISION)
        =========================================================

        ❌ MISTAKE #1:
        Using max heap of size n

        👉 Leads to O(n log n) (same as sorting)

        ✅ Use MIN heap of size k

        -----------------------------------------------------

        ❌ MISTAKE #2:
        Forgetting to remove when size > k

        👉 Heap grows to n → wrong answer

        -----------------------------------------------------

        ❌ MISTAKE #3:
        Confusion:
        "Why min heap for kth largest?"

        👉 Because:
        Root = smallest among k largest
        → exactly kth largest

        -----------------------------------------------------

        ❌ MISTAKE #4:
        Returning wrong element

        ❌ WRONG:
        return removed element

        ✅ CORRECT:
        return minHeap.peek()

        -----------------------------------------------------

        ❌ MISTAKE #5:
        Thinking:
        "Heap must contain all elements"

        👉 WRONG
        Only k elements are needed

        =========================================================
        🔥 FINAL RULE
        =========================================================

        Kth largest → MIN heap of size K
        Kth smallest → MAX heap of size K

        =========================================================
        */
    }
}
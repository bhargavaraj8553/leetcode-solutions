class Solution {

    /*
    =========================================================
    🧠 INTUITION
    =========================================================
    Problem: Top K Frequent Elements

    Goal:
    Find k elements with highest frequency

    Brute force:
    - Count frequencies → sort → pick top k → O(n log n)

    Optimized:
    - Use MIN HEAP of size k → O(n log k)

    =========================================================
    💡 HOW TO THINK
    =========================================================
    Maintain only top k frequent elements

    Heap stores:
    (element, frequency)

    Heap type:
    MIN heap → smallest frequency at top

    Why?
    - If heap size > k → remove smallest frequency
    - So only k highest frequencies remain
    */

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each element
        HashMap<Integer, Integer> freqCountMap = new HashMap<>();

        for (int num : nums) {
            freqCountMap.put(num, freqCountMap.getOrDefault(num, 0) + 1);
        }

        /*
        =========================================================
        Step 2: Create Min Heap based on frequency
        =========================================================

        Comparator:
        (o1, o2) -> o1.getValue() - o2.getValue()

        Meaning:
        - Smaller frequency → higher priority
        - So smallest freq element is at top

        */
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        /*
        =========================================================
        Step 3: Process map entries
        =========================================================
        */
        for (Map.Entry<Integer, Integer> mapEntry : freqCountMap.entrySet()) {

            // Add entry (element, frequency)
            pq.add(mapEntry);

            // Maintain heap size = k
            if (pq.size() > k) {

                // Remove smallest frequency element
                pq.remove();
            }
        }

        /*
        =========================================================
        Step 4: Extract result
        =========================================================
        */
        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {

            // Extract element (order not guaranteed)
            ans[i++] = pq.remove().getKey();
        }

        return ans;

        /*
        =========================================================
        ⏱️ TIME & SPACE COMPLEXITY
        =========================================================

        Time:
        O(n log k)
        - n insertions into heap
        - each insertion/removal → log k

        Space:
        O(n) → map
        O(k) → heap

        =========================================================
        🚨 YOUR PAST MISTAKE (IMPORTANT REVISION)
        =========================================================

        ❌ MISTAKE:
        Used:
        if (pq.size() >= k)

        👉 This removes element too early
        (even when heap just reached size k)

        -----------------------------------------------------

        ✅ FIX:
        if (pq.size() > k)

        👉 Allow heap to reach size k
        Then remove extra elements

        -----------------------------------------------------

        ❌ WRONG THINKING:
        "Keep size less than k"

        ✅ CORRECT THINKING:
        "Allow size = k, remove when it exceeds"

        =========================================================
        🔥 FINAL RULE
        =========================================================

        Top K problem → MIN heap of size k

        Heap stores:
        (value, frequency)

        Comparator decides:
        who stays / who gets removed

        =========================================================
        */
    }
}
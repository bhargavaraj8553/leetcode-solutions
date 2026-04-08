class Solution {

    /*
    =========================================================
    🧠 INTUITION
    =========================================================
    Problem: Task Scheduler

    Goal:
    Execute tasks with cooldown 'n' such that
    same tasks are at least n distance apart.

    Key Idea:
    - Always execute the task with highest frequency first
    - Use MAX HEAP to pick most frequent task
    - Process tasks in cycles of (n + 1)

    Why (n + 1)?
    - After executing a task, we need n gaps before repeating it
    - So in one cycle, we can execute at most (n + 1) DIFFERENT tasks

    =========================================================
    💡 HOW TO THINK
    =========================================================
    Heap → which task to execute next
    Temp list → tasks cooling down

    Flow:
    - Pick up to (n+1) tasks
    - Reduce their frequency (freq--)
    - Reinsert remaining tasks
    */

    public int leastInterval(char[] tasks, int n) {

        /*
        Step 1: Count frequency of each task
        */
        HashMap<Character, Integer> numberFreqMap = new HashMap<>();

        for (char c : tasks) {
            numberFreqMap.put(c, numberFreqMap.getOrDefault(c, 0) + 1);
        }

        /*
        Step 2: Max Heap (store frequencies)
        */
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all frequencies to heap
        pq.addAll(numberFreqMap.values());

        int time = 0;

        /*
        =========================================================
        Step 3: Process tasks in cycles
        =========================================================
        */
        while (!pq.isEmpty()) {

            // Stores tasks to be re-added after cooldown
            ArrayList<Integer> temp = new ArrayList<>();

            /*
            Process up to (n + 1) tasks in one cycle
            */
            for (int i = 0; i < n + 1; i++) {

                if (!pq.isEmpty()) {

                    // Get most frequent task
                    int freq = pq.peek();
                    pq.remove();

                    /*
                    Execute task once
                    → reduce its remaining frequency
                    */
                    freq--;

                    // Add to temp (if still pending)
                    temp.add(freq);
                }
            }

            /*
            Reinsert remaining tasks (still have frequency > 0)
            */
            for (int f : temp) {
                if (f > 0) {
                    pq.add(f);
                }
            }

            /*
            =========================================================
            Time calculation
            =========================================================
            */

            if (pq.isEmpty()) {
                /*
                Last cycle:
                No idle needed
                Only count actual executed tasks
                */
                time += temp.size();
            } else {
                /*
                Full cycle:
                Even if some slots unused → count as idle
                */
                time += n + 1;
            }
        }

        return time;

        /*
        =========================================================
        ⏱️ TIME & SPACE COMPLEXITY
        =========================================================

        Let:
        N = number of tasks
        K = number of unique tasks (max 26)

        Time:
        O(N log K)
        - Each task processed once
        - Heap operations → log K

        Since K ≤ 26 → effectively O(N)

        -----------------------------------------------------

        Space:
        O(K)
        - Heap stores at most K elements
        - Map stores K elements

        =========================================================
        🚨 YOUR LEARNING / MISTAKE TRACKER
        =========================================================

        ❌ MISTAKE (earlier):
        Forgot to add frequencies into heap

        ✅ FIX:
        pq.addAll(map.values())

        -----------------------------------------------------

        ❌ MISTAKE:
        Confusion about freq--

        ✅ UNDERSTAND:
        freq-- = "task executed once"

        -----------------------------------------------------

        ❌ MISTAKE:
        Not understanding cycle (n+1)

        ✅ FIX:
        In one cycle, we execute max (n+1) tasks

        -----------------------------------------------------

        ❌ MISTAKE:
        Thinking heap sorts everything

        ✅ TRUTH:
        Heap only gives best element (top)

        =========================================================
        🔥 FINAL RULE
        =========================================================

        Scheduling + frequency + constraint →
        Use MAX HEAP + cycle simulation

        =========================================================
        */
    }
}
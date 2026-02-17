class Solution {

    /*
    PROBLEM: Zigzag Level Order Traversal
    Return level order traversal where direction alternates
    (left → right, then right → left).
    */

    /*
    BRUTE FORCE INTUITION:
    - Do normal level order traversal
    - Reverse every alternate level

    ❌ Drawback:
    - Extra reverse operation per level

    WHY THIS APPROACH (OPTIMAL):
    - Still BFS (level-based problem)
    - Control direction while inserting elements
    - Avoid reversing lists
    */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Stores final zigzag traversal
        List<List<Integer>> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return ans;

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        /*
        Direction flag:
        true  -> left to right
        false -> right to left
        */
        boolean isForwardOrder = true;

        /*
        BFS traversal: each while-loop iteration = one level
        */
        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int queueSize = queue.size();

            // Stores values of current level
            List<Integer> oneLevel = new ArrayList<>();

            /*
            Process all nodes of the current level
            */
            for (int i = 0; i < queueSize; i++) {

                TreeNode polled = queue.poll();

                /*
                Insert based on direction:
                - Forward  -> add at end
                - Backward -> add at beginning
                */
                if (isForwardOrder) {
                    oneLevel.add(polled.val);
                } else {
                    oneLevel.add(0, polled.val);
                }

                // Add children for next level
                if (polled.left != null) queue.offer(polled.left);
                if (polled.right != null) queue.offer(polled.right);
            }

            // Add current level to answer
            ans.add(oneLevel);

            // Flip direction for next level
            isForwardOrder = !isForwardOrder;
        }

        return ans;
    }

    /*
    ⏱ Time Complexity (TC): O(N)
    - Each node is visited once

    📦 Space Complexity (SC): O(N)
    - Queue + result list
    */

    /*
    VALUE-ADDED NOTES:
    - Zigzag = normal BFS + direction toggle
    - Traversal order never changes, insertion order does
    - If interviewer asks optimization:
      use LinkedList and addFirst/addLast
    */
}

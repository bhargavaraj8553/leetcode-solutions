/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        /*
        🧠 PROBLEM: Preorder Traversal (Root → Left → Right)

        🔹 Brute Force Intuition:
        We normally solve tree traversals using recursion (DFS).
        Preorder means:
            1. Visit root
            2. Traverse left subtree
            3. Traverse right subtree

        🔹 Why Iterative / Stack Approach?
        Recursion internally uses a call stack.
        Here we simulate that recursion manually using an explicit Stack
        to avoid recursion and understand traversal flow better.

        🔹 How to Think About This Approach?
        Stack is LIFO, but preorder needs Root → Left → Right.
        So we push RIGHT first and LEFT later.
        This ensures LEFT gets processed first when popping.
        */

        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return ans;

        // Start with root node
        st.push(root);

        while (!st.isEmpty()) {
            // Step 1: Process the node at top of stack
            TreeNode topEl = st.pop();
            ans.add(topEl.val);  // Preorder → add root before children

            /*
            Step 2: Push children into stack
            IMPORTANT: Push RIGHT first, then LEFT
            Because stack pops the last pushed element first.
            This guarantees LEFT subtree is processed before RIGHT.
            */
            if (topEl.right != null) st.push(topEl.right);
            if (topEl.left != null) st.push(topEl.left);
        }

        /*
        ⏱ Time Complexity: O(N)
        Each node is pushed and popped exactly once.

        📦 Space Complexity: O(H)
        Stack stores at most height(H) nodes in balanced tree,
        worst case O(N) for skewed tree.
        */

        return ans;
    }
}

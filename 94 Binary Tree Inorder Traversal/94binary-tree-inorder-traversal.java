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
    public List<Integer> inorderTraversal(TreeNode root) {

        /*
        🧠 PROBLEM: Inorder Traversal (Left → Root → Right)

        🔹 Brute Force Intuition (Recursive Thinking):
        In recursion we do:
            inorder(root.left)
            process root
            inorder(root.right)

        🔹 Why Iterative + Stack?
        Recursion uses the system call stack to remember parent nodes.
        Here we manually simulate that behavior using our own Stack.

        🔹 Core Idea:
        We want to go as LEFT as possible first.
        But before moving left, we must remember the current node
        so we can come back later to process it and explore its right side.
        That "remembering" is done using a STACK.
        */

        TreeNode node = root;                 // Pointer to traverse the tree
        List<Integer> ans = new ArrayList<>(); // Stores inorder result
        Stack<TreeNode> st = new Stack<>();    // Simulates recursion stack

        /*
        Continue traversal as long as:
        - We still have nodes to explore (node != null)
        OR
        - There are nodes stored in stack waiting to be processed
        */
        while (node != null || !st.isEmpty()) {

            /*
            STEP 1: Go to the leftmost node
            Keep pushing nodes to stack before moving left.
            This postpones processing of the node until its left subtree is done.
            */
            while (node != null) {
                st.push(node);      // Save node for later (like recursion call stack)
                node = node.left;   // Move left
            }

            /*
            Now node is null → left subtree is fully explored.
            Time to "return" to the most recent unprocessed node.
            In recursion this would be returning from function call.
            Here we simulate that using stack.pop().
            */
            TreeNode top = st.pop();   // This is the parent node we postponed
            ans.add(top.val);          // ROOT step of inorder traversal

            /*
            STEP 2: After processing a node,
            we must explore its RIGHT subtree.
            So we move the pointer to right child.
            The loop will again try going as left as possible from there.
            */
            node = top.right;
        }

        /*
        ⏱ Time Complexity: O(N)
        Each node is pushed once and popped once.

        📦 Space Complexity: O(H)
        H = height of tree (recursion depth simulation).
        Worst case O(N) for skewed tree.
        */

        return ans;
    }
}

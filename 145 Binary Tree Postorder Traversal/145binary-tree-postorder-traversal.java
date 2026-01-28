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
    public List<Integer> postorderTraversal(TreeNode root) {

        /*
        🧠 PROBLEM: Postorder Traversal (Left → Right → Root)

        🔹 Why is this hard iteratively?
        Because a node can only be processed AFTER both its
        left and right subtrees are finished.

        🔹 Core Idea of 1-Stack Approach:
        We simulate recursion manually.
        - Stack represents the recursion call stack (path from root to current node)
        - lastVisited helps us know whether we just returned from a node’s right subtree

        IMPORTANT UNDERSTANDING:
        When we peek a node from stack, its LEFT subtree is already done
        (because we always go left first).
        The only question remaining is:
            "Has the RIGHT subtree been processed yet?"
        */

        Stack<TreeNode> st = new Stack<>();     // Simulates recursion stack
        List<Integer> ans = new ArrayList<>();  // Stores postorder result
        TreeNode lastVisited = null;            // Tracks last node that was processed
        TreeNode curr = root;                   // Traversal pointer

        // Continue while there are nodes to explore
        while (!st.isEmpty() || curr != null) {

            /*
            STEP 1: Go as left as possible
            Same as recursion going deeper into left subtree.
            We push nodes to stack to remember the path back.
            */
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            /*
            STEP 2: Look at the node on top of the stack
            DO NOT pop yet — because we may need to visit its right subtree first
            */
            TreeNode top = st.peek();

            /*
            CASE 1: Right subtree is either absent
                    OR already processed (lastVisited == top.right)

            That means BOTH left and right subtrees are done.
            So now we can safely process the node (postorder rule).
            */
            if (top.right == null || top.right == lastVisited) {
                st.pop();                   // Simulates returning from recursion
                ans.add(top.val);           // Process the node
                lastVisited = top;          // Mark this node as last processed
            }
            /*
            CASE 2: Right subtree exists and has NOT been processed yet
            We must go there before processing this node.
            */
            else {
                curr = top.right;           // Move to right subtree
            }
        }

        /*
        ⏱ Time Complexity: O(N)
        Each node is pushed and popped once.

        📦 Space Complexity: O(H)
        H = height of tree (stack depth).
        Worst case O(N) for skewed tree.
        */

        return ans;
    }
}

//
//class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//
//        /*
//        🧠 PROBLEM: Postorder Traversal (Left → Right → Root)
//
//        🔹 Why Postorder Is Hard Iteratively?
//        In postorder, a node can be processed only AFTER
//        both its left and right subtrees are processed.
//        This creates a dependency that is difficult to track
//        using a single stack.
//
//        🔹 Key Insight (Core Intuition):
//        Reverse of postorder (Left → Right → Root) is:
//            Root → Right → Left
//
//        Stack-based DFS can easily generate
//            Root → Right → Left
//        If we store this order and reverse it at the end,
//        we get the required postorder traversal.
//
//        🔹 Why Two Stacks?
//        - Stack 1 (st1): Used for traversal (DFS order)
//        - Stack 2 (st2): Used to reverse the traversal order
//        */
//
//        Stack<TreeNode> st1 = new Stack<>();   // Traversal stack
//        Stack<TreeNode> st2 = new Stack<>();   // Reversal stack
//        List<Integer> ans = new ArrayList<>();
//
//        // Edge case: empty tree
//        if (root == null) return ans;
//
//        // Start traversal from root
//        st1.push(root);
//
//        /*
//        STEP 1:
//        Generate Root → Right → Left order using st1
//        */
//        while (!st1.isEmpty()) {
//
//            // Pop current node from traversal stack
//            TreeNode node = st1.pop();
//
//            // Store node in st2 (this postpones final processing)
//            st2.push(node);
//
//            /*
//            Push children into st1.
//            IMPORTANT:
//            Left is pushed before Right so that
//            Right gets processed first (LIFO nature of stack).
//            This produces Root → Right → Left order.
//            */
//            if (node.left != null) st1.push(node.left);
//            if (node.right != null) st1.push(node.right);
//        }
//
//        /*
//        STEP 2:
//        Reverse Root → Right → Left to get
//        Left → Right → Root (Postorder)
//        */
//        while (!st2.isEmpty()) {
//            ans.add(st2.pop().val);
//        }
//
//        /*
//        ⏱ Time Complexity: O(N)
//        Each node is pushed and popped exactly twice.
//
//        📦 Space Complexity: O(N)
//        Two stacks may hold up to N nodes in worst case.
//        */
//
//        return ans;
//    }
//}

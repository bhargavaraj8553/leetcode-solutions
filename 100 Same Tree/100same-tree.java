class Solution {

    /*
    =========================
    PROBLEM: Same Tree
    =========================
    Given two binary trees, check whether they are structurally identical
    and have the same node values.
    */

    /*
    -------------------------------------------------
    1️⃣ BRUTE FORCE INTUITION
    -------------------------------------------------
    - Traverse both trees completely
    - Store their traversals (inorder / preorder) in lists
    - Compare the lists

    ❌ Problems with brute force:
    - Extra space for storing traversals
    - Traversal alone does NOT guarantee structure match
      (different trees can have same inorder traversal)
    */

    /*
    -------------------------------------------------
    2️⃣ WHY THIS RECURSIVE APPROACH (OPTIMAL)
    -------------------------------------------------
    - Tree structure is recursive by nature
    - Two trees are the same IF:
        a) Current nodes are same
        b) Left subtrees are same
        c) Right subtrees are same
    - This naturally fits recursion
    - No extra data structures needed
    */

    /*
    -------------------------------------------------
    3️⃣ HOW TO THINK ABOUT THIS APPROACH
    -------------------------------------------------
    Ask this at EVERY node:
    "Are these two nodes identical?"

    They are identical ONLY IF:
    - Both are null  → same
    - One is null    → not same
    - Values differ  → not same
    - Left subtrees are same AND right subtrees are same

    This thinking leads directly to the code.
    */

    public boolean isSameTree(TreeNode p, TreeNode q) {

        /*
        CASE 1:
        One node is null and the other is not.
        Structure differs → trees are NOT same.
        */
        if ((p == null && q != null) || (p != null && q == null)) 
            return false;

        /*
        CASE 2:
        Both nodes are null.
        Subtrees match perfectly → return true.
        */
        if (p == null) 
            return true;

        /*
        CASE 3:
        Both nodes exist but values differ.
        Trees are NOT same.
        */
        if (p.val != q.val)
            return false;

        /*
        RECURSIVE CHECK:
        - Check left subtree
        - Check right subtree

        Both must be true for trees to be identical.
        */
        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isLeftSame && isRightSame;
    }

    /*
    -------------------------------------------------
    ⏱ TIME COMPLEXITY (TC)
    -------------------------------------------------
    O(N)
    - Each node is visited exactly once
    - N = number of nodes in the tree

    -------------------------------------------------
    📦 SPACE COMPLEXITY (SC)
    -------------------------------------------------
    O(H)
    - H = height of the tree (recursion stack)
    - Worst case (skewed tree): O(N)
    - Best case (balanced tree): O(log N)
    */

    /*
    -------------------------------------------------
    🔑 VALUE-ADDED NOTES (IMPORTANT)
    -------------------------------------------------
    ❌ Do NOT compare inorder/preorder lists
       → structure can differ with same traversal

    ❌ Do NOT compare only values
       → structure matters equally

    ✅ Always check:
       - null vs non-null
       - value equality
       - left AND right subtree recursively
    */
}

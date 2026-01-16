class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Stack will store the asteroids that are still "alive"
        // We simulate collisions while scanning from left to right.
        //
        // Collision happens only when:
        // stack top is moving right  (+)
        // current asteroid is moving left (-)
        // i.e. st.peek() > 0 && asteroids[i] < 0

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            // if stack empty, directly push asteroid
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            } else {

                // If current asteroid is moving left
                if (asteroids[i] < 0) {

                    // Current negative asteroid may destroy smaller positive asteroids on stack
                    // Keep popping while:
                    // - stack not empty
                    // - top is positive (moving right)
                    // - top is smaller than current asteroid (by absolute value)
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                        st.pop();
                    }

                    // After popping smaller positives, there are 3 cases:
                    // 1) stack empty -> current survives -> push
                    // 2) top is negative -> no collision -> push
                    // 3) top is positive:
                    //    a) if equal size -> both destroyed (pop top, don't push current)
                    //    b) if top bigger -> current destroyed (do nothing)

                    if (st.isEmpty() || st.peek() < 0) {
                        st.push(asteroids[i]);
                    } 
                    // equal size => both destroyed
                    else if (st.peek() == -asteroids[i]) {
                        st.pop();
                    }
                    // else top is bigger => current asteroid destroyed, so we don't push it

                } 
                // If current asteroid is moving right, it never collides with previous ones
                else {
                    st.push(asteroids[i]);
                }
            }
        }

        // If no asteroids survive
        if (st.isEmpty()) {
            return new int[0];
        }

        // Convert stack to array in correct order
        // Stack has correct order from bottom to top,
        // so fill answer from end to start while popping.
        int size = st.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        /*
         * Time Complexity (TC): O(2N)
         * - Each asteroid is pushed once
         * - Each asteroid can be popped at most once
         * Total operations <= 2N
         *
         * Space Complexity (SC): O(N)
         * - Stack can hold up to N asteroids in worst case
         * - Answer array is required for output
         */
        return ans;
    }
}

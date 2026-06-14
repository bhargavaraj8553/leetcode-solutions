class Solution {
    public boolean checkValidString(String s) {

        /*
         * Intuition:
         * Instead of tracking one exact count of open brackets,
         * track a RANGE of possible open brackets.
         *
         * minRange = minimum possible unmatched '(' till now
         * maxRange = maximum possible unmatched '(' till now
         *
         * Why?
         * Because '*' can act as:
         * 1. '('
         * 2. ')'
         * 3. empty string
         *
         * So after seeing '*', there isn't one answer,
         * there is a range of possible answers.
         */

        int minRange = 0;
        int maxRange = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {

                // Definitely one more open bracket
                minRange++;
                maxRange++;

            } else if (c == ')') {

                // One open bracket gets closed
                minRange--;
                maxRange--;

            } else {

                /*
                 * '*' can be:
                 *
                 * ')' => open count decreases
                 * '(' => open count increases
                 * ''  => open count unchanged
                 *
                 * Therefore:
                 *
                 * minimum possible opens decreases by 1
                 * maximum possible opens increases by 1
                 */

                minRange--;
                maxRange++;
            }

            /*
             * minRange cannot be negative.
             *
             * Example:
             * open count = -1 is impossible.
             *
             * So clamp it to 0.
             */
            if (minRange < 0) {
                minRange = 0;
            }

            /*
             * If maxRange becomes negative,
             * even in the BEST case we have more ')'
             * than available '('.
             *
             * String can never become valid.
             */
            if (maxRange < 0) {
                return false;
            }
        }

        /*
         * For a valid string,
         * it should be possible to end with
         * exactly 0 unmatched '('.
         *
         * minRange == 0 means
         * there exists at least one interpretation
         * of '*' that makes the string valid.
         */
        return minRange == 0;
    }
}

/*
 * How to Think of This Approach:
 *
 * Instead of asking:
 * "What is the exact number of open brackets?"
 *
 * Ask:
 * "What is the minimum and maximum number of open brackets
 * I could possibly have at this point?"
 *
 * This converts an exponential brute force problem
 * into a simple linear scan.
 *
 * Example:
 *
 * s = "(*"
 *
 * After '(':
 * min=1 max=1
 *
 * After '*':
 * min=0 max=2
 *
 * Meaning:
 * possible open counts are:
 * 0, 1, or 2
 *
 * We don't care about exact values.
 * We only care whether 0 remains possible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
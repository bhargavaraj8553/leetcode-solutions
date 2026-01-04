class Solution {

    // Main function:
    // For each number in the array, compute the sum of its divisors
    // ONLY IF it has exactly 4 divisors, otherwise add 0.
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        // Process each number independently
        for (int num : nums) {
            ans += sumOfDivisors(num);
        }

        return ans;
    }

    // Returns:
    // - sum of divisors IF number has exactly 4 divisors
    // - 0 otherwise
    private int sumOfDivisors(int num) {

        int i = 1;

        // Counts how many divisors we have found so far
        int divisorsCount = 0;

        // Stores sum of all divisors found
        int sumOfDivisors = 0;

        /*
         * IMPORTANT:
         * We iterate only till i*i <= num
         * Reason:
         * Divisors always come in pairs (i, num/i)
         * This avoids O(n) iteration and handles perfect squares safely
         *
         * MISTAKE I MADE EARLIER:
         * Using (i*i < num) skipped perfect square divisors (like 4 in 16)
         */
        while ((i * i) <= num) {

            // Check if i is a divisor
            if (num % i == 0) {

                int d1 = i;        // first divisor
                int d2 = num / i;  // paired divisor

                /*
                 * Case 1: Perfect square
                 * Example: num = 16, i = 4 → (4,4)
                 *
                 * MISTAKE I MADE EARLIER:
                 * Counting both would double-count the same divisor
                 */
                if (d1 == d2) {
                    divisorsCount += 1;
                    sumOfDivisors += d1;
                }

                /*
                 * Case 2: Normal divisor pair
                 * Example: num = 10 → (1,10), (2,5)
                 *
                 * MISTAKE I MADE EARLIER:
                 * I was not counting BOTH divisors correctly
                 */
                else {
                    divisorsCount += 2;
                    sumOfDivisors += d1 + d2;
                }
            }

            i++;

            /*
             * OPTIMIZATION:
             * If divisors exceed 4, we don't care anymore
             *
             * MISTAKE I MADE EARLIER:
             * Continuing even when divisor count already exceeded 4
             */
            if (divisorsCount > 4) return 0;
        }

        /*
         * Final check:
         * Only numbers with EXACTLY 4 divisors are valid
         *
         * Valid forms:
         * - p^3 (prime cube)
         * - p * q (product of two distinct primes)
         */
        if (divisorsCount == 4) return sumOfDivisors;

        return 0;
    }
}

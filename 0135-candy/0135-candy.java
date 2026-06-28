class Solution {
    public int candy(int[] ratings) {

        // Single Pass Greedy
        // Treat ratings as mountains (uphill & downhill).
        // Count increasing slope (peak) and decreasing slope.
        // If downhill is longer than uphill, compensate the peak.
        //
        // TC: O(N)
        // SC: O(1)

        int sum = 1;
        int i = 1;
        int n = ratings.length;

        while (i < n) {

            // Equal ratings -> both can have one candy
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Traverse increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Traverse decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // Peak should get maximum candies from both slopes
            if (down > peak) {
                sum += down - peak;
            }
        }

        return sum;
    }
}


//
//class Solution {
//    public int candy(int[] ratings) {
//
//        // Two Pass Greedy
//        // 1. Left to Right: Satisfy left neighbour condition.
//        // 2. Right to Left: Satisfy right neighbour condition.
//        // 3. Take maximum candies required from both directions.
//        //
//        // TC: O(2N)
//        // SC: O(N)
//
//        int n = ratings.length;
//        int[] left = new int[n];
//
//        // First child gets one candy
//        left[0] = 1;
//
//        // Left to Right traversal
//        for (int i = 1; i < n; i++) {
//
//            // Higher rating than left neighbour
//            if (ratings[i] > ratings[i - 1]) {
//                left[i] = left[i - 1] + 1;
//            } else {
//                left[i] = 1;
//            }
//        }
//
//        // Right traversal starts with one candy
//        int right = 1;
//        int current = 1;
//
//        // Last child's contribution
//        int sum = Math.max(1, left[n - 1]);
//
//        // Right to Left traversal
//        for (int i = n - 2; i >= 0; i--) {
//
//            // Higher rating than right neighbour
//            if (ratings[i] > ratings[i + 1]) {
//                current = right + 1;
//                right = current;
//            } else {
//                current = 1;
//                right = 1;
//            }
//
//            // Take maximum candies needed from both directions
//            sum += Math.max(left[i], current);
//        }
//
//        return sum;
//    }
//}

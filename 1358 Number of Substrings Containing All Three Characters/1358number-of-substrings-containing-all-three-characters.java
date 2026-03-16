class Solution {
    public int numberOfSubstrings(String s) {

        /*
        Problem:
        Count substrings containing at least one 'a', 'b', and 'c'.
        */

        /*
        charArr[i] stores the LAST INDEX where:
            0 → 'a'
            1 → 'b'
            2 → 'c'

        Initialize with -1 meaning character not seen yet.
        */
        int[] charArr = new int[3];
        Arrays.fill(charArr, -1);

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            /*
            Update last seen index of current character.
            Example:
            'a' → index 0
            'b' → index 1
            'c' → index 2
            */
            charArr[s.charAt(i) - 'a'] = i;

            /*
            If all three characters have appeared
            then we can form valid substrings ending at i.
            */
            if (charArr[0] != -1 && charArr[1] != -1 && charArr[2] != -1) {

                /*
                The earliest occurrence among a,b,c determines
                how many valid starting positions exist.

                Example:
                lastSeen = [2,4,5]

                earliest = 2

                Valid starts = 0..2 → total = 3
                */
                count += Math.min(charArr[0],
                         Math.min(charArr[1], charArr[2])) + 1;
            }
        }

        /*
        Time Complexity:  O(N)
        Space Complexity: O(1)
        */
        return count;
    }
}
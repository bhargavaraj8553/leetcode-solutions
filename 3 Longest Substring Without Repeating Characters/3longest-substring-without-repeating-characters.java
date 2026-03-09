class Solution {

    public int lengthOfLongestSubstring(String s) {

        /*
        Problem:
        --------
        Given a string, find the length of the longest substring without repeating characters.

        Example:
        --------
        s = "tmmzuxt"
        Longest substring without duplicates = "mzuxt"
        length = 5

        Key Idea:
        ---------
        Use the Sliding Window technique.

        We maintain a window:
        [l .... r]

        l = left boundary of window
        r = right boundary of window

        As we expand r, we check if the character already appeared inside the window.

        If yes → move l forward to remove the duplicate.

        Optimization:
        -------------
        Instead of removing characters one-by-one (Set solution),
        we store the last index of every character using a HashMap.

        This allows us to jump the left pointer directly.

        Time Complexity:
        ----------------
        O(N)

        Each character is processed once.

        Space Complexity:
        -----------------
        O(K)

        K = number of distinct characters (max 128 for ASCII)
        */

        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        int l = 0;           // left pointer of sliding window
        int r = 0;           // right pointer
        int maxLength = 0;   // stores maximum substring length found

        while (r < s.length()) {

            char currentChar = s.charAt(r);

            /*
            If character already exists in the map,
            it means we saw it before.

            But we only care if it exists inside the CURRENT window.

            Example:
            --------
            "abba"

            When we see second 'b', its previous index might be outside window.
            So we check:

            previousIndex >= l

            Only then we update l.
            */

            if (charIndexMap.containsKey(currentChar)) {

                if (charIndexMap.get(currentChar) >= l) {

                    /*
                    Move left pointer just after the previous occurrence
                    to remove the duplicate from the window.
                    */

                    l = charIndexMap.get(currentChar) + 1;
                }
            }

            /*
            Update the maximum length of the valid window.
            Window size = r - l + 1
            */
            maxLength = Math.max(maxLength, r - l + 1);

            /*
            Store/update the last seen index of this character.
            */
            charIndexMap.put(currentChar, r);

            /*
            Expand window by moving r
            */
            r++;
        }

        return maxLength;
    }



    /*
    ------------------------------------------------------------------
    OLD APPROACH (Set-based Sliding Window)
    ------------------------------------------------------------------

    This approach also works but is slightly less optimized.

    Instead of jumping the left pointer, we shrink the window
    step-by-step until the duplicate character is removed.

    Time Complexity:
    ----------------
    O(2N) ≈ O(N)

    Because:
    r moves forward N times
    l moves forward at most N times

    Space Complexity:
    -----------------
    O(K) where K = distinct characters
    */

    /*
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charFreqSet = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxSize = 0;

        while (r < s.length()) {

            char rightVal = s.charAt(r);

            if (charFreqSet.contains(rightVal)) {

                // Shrink window until duplicate removed
                while (s.charAt(l) != rightVal) {
                    charFreqSet.remove(s.charAt(l));
                    l++;
                }

                // Remove the duplicate occurrence
                charFreqSet.remove(rightVal);
                l++;
            }

            // Add new character to the window
            charFreqSet.add(rightVal);

            r++;

            // Update maximum window size
            maxSize = Math.max(maxSize, r - l);
        }

        return maxSize;
    }
    */

}
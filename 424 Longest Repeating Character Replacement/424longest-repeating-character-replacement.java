class Solution {

    public int characterReplacement(String s, int k) {

        /*
        --------------------------------------------------
        IMPORTANT THINKING MISTAKE YOU MADE EARLIER
        --------------------------------------------------

        You previously tried solving this like:

            "at most K distinct characters"

        using:

            map.size() <= K

        That pattern is WRONG for this problem.

        WHY?

        Because this problem does NOT care about
        number of character types.

        It cares about:

            how many characters we must REPLACE
            to make the substring uniform.

        --------------------------------------------------
        CORRECT THINKING MODEL
        --------------------------------------------------

        In any window [l ... r], we will convert the
        entire window into the MOST FREQUENT character.

        Example:

            A A B A B

        Frequency:
            A = 3
            B = 2

        Best strategy:
            convert all characters → 'A'

        Replacements needed:

            window_size - maxFreq

        If replacements needed ≤ k
        the window is valid.

        VALID WINDOW CONDITION:

            (window_size - maxFreq) ≤ k
        */

        int l = 0;
        int r = 0;
        int maxLen = 0;

        /*
        IMPORTANT VARIABLE YOU WERE MISSING BEFORE

        maxFreq = frequency of the most frequent character
        inside the current window.

        Earlier you tried using:

            map.size()

        which measures "number of types".

        That was the WRONG metric.
        */
        int maxFreq = 0;

        /*
        Frequency array for characters.

        Your earlier version used HashMap which works,
        but array is faster because:

            characters are only A-Z

        Access becomes O(1).
        */
        int[] hash = new int[26];


        while (r < s.length()) {

            /*
            EXPAND WINDOW

            Earlier mistake you made:
            you accidentally updated frequency using 'l'
            instead of 'r'.

            Always remember:

                r = expanding pointer
                l = shrinking pointer

            So frequency must increase using r.
            */
            hash[s.charAt(r) - 'A']++;

            /*
            Update maxFreq.

            This tracks the most frequent character
            inside the window.

            KEY INSIGHT:

            We only update maxFreq while expanding.
            */
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);


            /*
            INVALID WINDOW CONDITION

            This is the key formula you struggled to derive:

                replacements_needed > k

            replacements_needed = window_size - maxFreq

            So window invalid if:

                (r-l+1) - maxFreq > k
            */
            while ((r - l + 1) - maxFreq > k) {

                /*
                SHRINK WINDOW FROM LEFT

                Remove s[l] from window.
                */
                hash[s.charAt(l) - 'A']--;


                /*
                THINKING MISTAKE YOU MADE EARLIER

                You thought maxFreq must always be exact.

                So you recomputed it here.

                This works but is NOT optimal.

                Why?

                Because scanning 26 characters each time
                makes complexity:

                    O(26 * N)

                The optimal trick is:

                    DO NOT decrease maxFreq.

                Even if it becomes slightly outdated,
                the algorithm still works.

                But your version is still logically correct.
                */
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }

                l++;
            }


            /*
            WINDOW IS VALID NOW

            Update answer.

            Earlier you incorrectly used conditions like:

                window_size <= k

            which ignored maxFreq completely.

            Correct condition is always:

                window_size - maxFreq ≤ k
            */
            maxLen = Math.max(maxLen, r - l + 1);


            /*
            Continue expanding window
            */
            r++;
        }

        return maxLen;
    }
}
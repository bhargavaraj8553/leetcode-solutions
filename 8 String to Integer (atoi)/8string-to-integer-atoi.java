class Solution {
    public int myAtoi(String s) {
        int number = 0;
        boolean negative = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '-') {
                    negative = true;
                    continue;
                } else if (c == '+') {
                    continue;
                }
            }
            if (c >= '0' && c <= '9') {
                if (number> Integer.MAX_VALUE /10){
                    return negative? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
                if (number == Integer.MAX_VALUE / 10) {
                    if ((!negative && (c-'0'>7)) || (negative && (c-'0')>=8)){
                        return !negative? Integer.MAX_VALUE :Integer.MIN_VALUE;
                    }
                }
                number = (10 * number) + c - '0';
            } else {
                break;
            }

        }
        return !negative ? number : (-1) * number;
    }
}
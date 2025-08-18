class Solution {
    public int maxDepth(String s) {
        StringBuilder sb = new StringBuilder(s);
        int maxVal = 0;
        int overAllCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                overAllCount++;
            } else if (c == ')') {
                overAllCount--;
            }
            maxVal = Integer.max(maxVal, overAllCount);
        }
        return maxVal;
    }
}
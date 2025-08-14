class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for(String str:strs){
            if (str.length() < minLen){
                minLen = str.length();
                minStr = str;
            }
        }
        int endIndex = -1;
        outer:
        for (int i = 0; i < minLen; i++) {
            for (int j=0;j< strs.length;j++){
                if (strs[j].charAt(i) != minStr.charAt(i)) {
                    break outer;
                }
            }
            endIndex = i;
        }
        if(endIndex==-1) return "";
        return minStr.substring(0,endIndex+1);
    }
}
class Solution {
    public String reverseWords(String s) {

        String[] splitStrings = s.trim().split("\\s+"); // \\s+
        StringBuilder sb = new StringBuilder();
        for (int i = splitStrings.length-1;i>=0;i--){
            sb.append(splitStrings[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}
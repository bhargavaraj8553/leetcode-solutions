class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder();
        if(s.length()!= goal.length()) return false;
        sb.append(s);
        sb.append(s);
        return sb.indexOf(goal) != -1;
    }
}
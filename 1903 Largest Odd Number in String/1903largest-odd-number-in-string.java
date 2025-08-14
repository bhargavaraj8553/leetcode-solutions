
class Solution {
    public String largestOddNumber(String num) {
        int lastOdd=-1;
        for(int i =0;i<num.length();i++){
            int val = num.charAt(i)- '0';
            if(val%2!=0) lastOdd = i;
        }
        if (lastOdd==-1) return "";
        return num.substring(0,lastOdd+1);
    }
}
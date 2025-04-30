class Solution {
    public void reverseString(char[] string) {
        int k = string.length-1;
        for (int i =0;i<string.length/2;i++){
            char s= string[i];
            string[i]= string[k-i];
            string[k-i]=s;
        }
    }
}
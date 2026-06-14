
class Solution {
    public boolean checkValidString(String s) {
        int minRange =0; 
        int maxRange= 0;
        
        for (char c:s.toCharArray()){
            if (c=='('){
                minRange++;
                maxRange++;
            } else if (c==')'){
                minRange--;
                maxRange--;
            } else {
                minRange--;
                maxRange++;
            }
            if (minRange<0) minRange=0;
            if (maxRange<0) return false;
        }
        return minRange==0;
    }
    
}